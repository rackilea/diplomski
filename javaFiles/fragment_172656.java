import java.net.URLEncoder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import static java.nio.charset.StandardCharsets.*;

/**
* Mimics the OpenSSL AES Cipher options for encrypting and decrypting messages using a 
* shared key (aka password) with symetric ciphers.
*/

public class OpenSslAesQu {

    /** OpenSSL magic initial bytes. */
    private static final String SALTED_STR = "Salted__";
    private static final byte[] SALTED_MAGIC = SALTED_STR.getBytes(US_ASCII);

    public static String encryptAndURLEncode(String password, String clearText) {

        String encrypted = null;
        try {
            encrypted = URLEncoder.encode(encrypt(password, clearText),UTF_8.name());
        } catch (Exception e) {e.printStackTrace();}
        return encrypted;

    }

    /**
     * 
     * @param password  The password / key to encrypt with.
     * @param data      The data to encrypt
     * @return  A base64 encoded string containing the encrypted data.
     */

    public static String encrypt(String password, String clearText) {

        String encryptedMsg = null;
        final byte[] pass = password.getBytes(US_ASCII);
        final byte[] salt = (new SecureRandom()).generateSeed(8);
        final byte[] inBytes = clearText.getBytes(UTF_8);

        final byte[] passAndSalt = array_concat(pass, salt);
        byte[] hash = new byte[0];
        byte[] keyAndIv = new byte[0];

        try {
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
            //return Base64.getEncoder().encodeToString( data );        
            encryptedMsg = org.apache.commons.codec.binary.Base64.encodeBase64String(data);
        } catch(Exception e) {e.printStackTrace();}

        return encryptedMsg;
    }

    /**
     * @see http://stackoverflow.com/questions/32508961/java-equivalent-of-an-openssl-aes-cbc-encryption  for what looks like a useful answer.  The not-yet-commons-ssl also has an implementation
     * @param password
     * @param source The encrypted data
     */

    public static String decrypt(String password, String source) {

        String decryptedMsg = null;

        final byte[] pass = password.getBytes(US_ASCII);

        //final byte[] inBytes = Base64.getDecoder().decode(source);
        final byte[] inBytes = Base64.decodeBase64(source);

        final byte[] shouldBeMagic = Arrays.copyOfRange(inBytes, 0, SALTED_MAGIC.length);
        if (!Arrays.equals(shouldBeMagic, SALTED_MAGIC)) {
            throw new IllegalArgumentException("Initial bytes from input do not match OpenSSL SALTED_MAGIC salt value.");
        }

        final byte[] salt = Arrays.copyOfRange(inBytes, SALTED_MAGIC.length, SALTED_MAGIC.length + 8);

        final byte[] passAndSalt = array_concat(pass, salt);

        byte[] hash = new byte[0];
        byte[] keyAndIv = new byte[0];
        try {
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
        decryptedMsg = new String(clear, UTF_8);
        } catch (Exception e) {e.printStackTrace();}

        return decryptedMsg;
    }


    private static byte[] array_concat(final byte[] a, final byte[] b) {
        final byte[] c = new byte[a.length + b.length];
        System.arraycopy(a, 0, c, 0, a.length);
        System.arraycopy(b, 0, c, a.length, b.length);
        return c;
    }

    public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {

        String msg = "the decrypted message is this";       
        String password = "pass";

        System.out.println(">> "+encrypt(password,msg));
        //System.out.println("<< "+decrypt(encrypt(msg, password), password));

        String encryptedMsg = "U2FsdGVkX190A5FsNTanwTKBdex29SpnH4zWkZN+Ld+MmbJgK4BH1whGIRRSpOJT";
        String encryptedMsg2 = "U2FsdGVkX1/B6oOznz5+nd7W/qXwXI7G7rhj5o9pjx8MS0TXp9SNxO3AhM9HBJ/z";

        System.out.println(decrypt(password,encryptedMsg));
        System.out.println(decrypt(password,encryptedMsg2));
        System.out.println(decrypt(password,encrypt(password,msg)));
    }

}