package decryptoor;

import groovy.transform.CompileStatic;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URLEncoder;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.SecureRandom;
import static java.nio.charset.StandardCharsets.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Permission;
import java.security.PermissionCollection;
import java.util.Arrays;
import java.util.Base64;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
* Mimics the OpenSSL AES Cipher options for encrypting and decrypting messages using a shared key (aka password) with symetric ciphers.
*/
@CompileStatic
class OpenSslAes {

/** OpenSSL's magic initial bytes. */
private static final String SALTED_STR = "Salted__";
private static final byte[] SALTED_MAGIC = SALTED_STR.getBytes(US_ASCII);


static String encryptAndURLEncode(String password, String clearText) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, InvalidAlgorithmParameterException, BadPaddingException, UnsupportedEncodingException {

    String encrypted = encrypt(password, clearText);
    return URLEncoder.encode(encrypted, UTF_8.name() );
}

/**
 *
 * @param password  The password / key to encrypt with.
 * @param data      The data to encrypt
 * @return  A base64 encoded string containing the encrypted data.
 */
static String encrypt(String password, String clearText) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, InvalidAlgorithmParameterException, BadPaddingException {
    removeCryptographyRestrictions();
    final byte[] pass = password.getBytes(US_ASCII);
    final byte[] salt = (new SecureRandom()).generateSeed(8);
    final byte[] inBytes = clearText.getBytes(UTF_8);

    final byte[] passAndSalt = array_concat(pass, salt);
    byte[] hash = new byte[0];
    byte[] keyAndIv = new byte[0];
    for (int i = 0; i < 3 && keyAndIv.length < 48; i++) {
        final byte[] hashData = array_concat(hash, passAndSalt);
        final MessageDigest md = MessageDigest.getInstance("MD5");
        hash = md.digest(hashData);
        keyAndIv = array_concat(keyAndIv, hash);
    }

    final byte[] keyValue = Arrays.copyOfRange(keyAndIv, 0, 32);
    final byte[] iv = Arrays.copyOfRange(keyAndIv, 32, 48);
    final SecretKeySpec key = new SecretKeySpec(keyValue, "AES");

    final Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv));
    byte[] data = cipher.doFinal(inBytes);
    data =  array_concat(array_concat(SALTED_MAGIC, salt), data);
    return Base64.getEncoder().encodeToString( data );
}

/**
 * @see http://stackoverflow.com/questions/32508961/java-equivalent-of-an-openssl-aes-cbc-encryption  for what looks like a useful answer.  The not-yet-commons-ssl also has an implementation
 * @param password
 * @param source The encrypted data
 * @return
 */
static String decrypt(String password, String source) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
    removeCryptographyRestrictions();
    final byte[] pass = password.getBytes(US_ASCII);

    final byte[] inBytes = Base64.getDecoder().decode(source);

    final byte[] shouldBeMagic = Arrays.copyOfRange(inBytes, 0, SALTED_MAGIC.length);
    if (!Arrays.equals(shouldBeMagic, SALTED_MAGIC)) {
        throw new IllegalArgumentException("Initial bytes from input do not match OpenSSL SALTED_MAGIC salt value.");
    }

    final byte[] salt = Arrays.copyOfRange(inBytes, SALTED_MAGIC.length, SALTED_MAGIC.length + 8);

    final byte[] passAndSalt = array_concat(pass, salt);

    byte[] hash = new byte[0];
    byte[] keyAndIv = new byte[0];
    for (int i = 0; i < 3 && keyAndIv.length < 48; i++) {
        final byte[] hashData = array_concat(hash, passAndSalt);
        final MessageDigest md = MessageDigest.getInstance("MD5");
        hash = md.digest(hashData);
        keyAndIv = array_concat(keyAndIv, hash);
    }

    final byte[] keyValue = Arrays.copyOfRange(keyAndIv, 0, 32);
    final SecretKeySpec key = new SecretKeySpec(keyValue, "AES");

    final byte[] iv = Arrays.copyOfRange(keyAndIv, 32, 48);

    final Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv));
    final byte[] clear = cipher.doFinal(inBytes, 16, inBytes.length - 16);
    return new String(clear, UTF_8);
}


private static byte[] array_concat(final byte[] a, final byte[] b) {
    final byte[] c = new byte[a.length + b.length];
    System.arraycopy(a, 0, c, 0, a.length);
    System.arraycopy(b, 0, c, a.length, b.length);
    return c;
}

private static void removeCryptographyRestrictions() {
    if (!isRestrictedCryptography()) {
        return;
    }
    try {
        /*
         * Do the following, but with reflection to bypass access checks:
         * 
         * JceSecurity.isRestricted = false; JceSecurity.defaultPolicy.perms.clear();
         * JceSecurity.defaultPolicy.add(CryptoAllPermission.INSTANCE);
         */
        final Class<?> jceSecurity = Class.forName("javax.crypto.JceSecurity");
        final Class<?> cryptoPermissions = Class.forName("javax.crypto.CryptoPermissions");
        final Class<?> cryptoAllPermission = Class.forName("javax.crypto.CryptoAllPermission");

        Field isRestrictedField = jceSecurity.getDeclaredField("isRestricted");
        isRestrictedField.setAccessible(true);
        setFinalStatic(isRestrictedField, true);
        isRestrictedField.set(null, false);

        final Field defaultPolicyField = jceSecurity.getDeclaredField("defaultPolicy");
        defaultPolicyField.setAccessible(true);
        final PermissionCollection defaultPolicy = (PermissionCollection) defaultPolicyField.get(null);

        final Field perms = cryptoPermissions.getDeclaredField("perms");
        perms.setAccessible(true);
        ((Map<?, ?>) perms.get(defaultPolicy)).clear();

        final Field instance = cryptoAllPermission.getDeclaredField("INSTANCE");
        instance.setAccessible(true);
        defaultPolicy.add((Permission) instance.get(null));
    }
    catch (final Exception e) {
        e.printStackTrace();
    }
}

static void setFinalStatic(Field field, Object newValue) throws Exception {
      field.setAccessible(true);

      Field modifiersField = Field.class.getDeclaredField("modifiers");
      modifiersField.setAccessible(true);
      modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

      field.set(null, newValue);
   }

private static boolean isRestrictedCryptography() {
    // This simply matches the Oracle JRE, but not OpenJDK.
    return "Java(TM) SE Runtime Environment".equals(System.getProperty("java.runtime.name"));
}
}