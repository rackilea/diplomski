import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class KeyPairToString {
    private static final String ALGORITHM = "RSA";

    private static byte[] encrypt(byte[] publicKey, byte[] inputData) throws Exception {
        PublicKey key = KeyFactory.getInstance(ALGORITHM)    /* ExceptionL Invalid DER encoding */
                .generatePublic(new X509EncodedKeySpec(publicKey));
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(inputData);
    }

    private static byte[] decrypt(byte[] privateKey, byte[] inputData) throws Exception {
        PrivateKey key = KeyFactory.getInstance(ALGORITHM)
                .generatePrivate(new PKCS8EncodedKeySpec(privateKey));
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(inputData);
    }

    private static KeyPair generateKeyPair()
            throws NoSuchAlgorithmException, NoSuchProviderException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALGORITHM);
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
        keyGen.initialize(512, random);
        return keyGen.generateKeyPair();
    }

    private static String bytesToString(byte[] bytes) {
        return new String(bytes);
    }

    private static byte[] stringToBytes(String astring) {
        return astring.getBytes();
    }

    private static String bytesToEncodedString(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    private static byte[] encodedStringToBytes(String encodedString) {
        return Base64.getDecoder().decode(encodedString);
    }

    public static void main(String[] args) throws Exception {
        KeyPair generateKeyPair = generateKeyPair();

        byte[] publicKey = generateKeyPair.getPublic().getEncoded();
        byte[] privateKey = generateKeyPair.getPrivate().getEncoded();

        // Byte array
        String secretText = "hi this is secret johan here";
        byte[] encryptedData = encrypt(publicKey, secretText.getBytes());
        byte[] decryptedData = decrypt(privateKey, encryptedData);
        System.out.println(new String(decryptedData));

        // Now with Strings
        String encodedPublicKeyString = bytesToEncodedString(publicKey);
        String encodedPrivateKeyString = bytesToEncodedString(privateKey);
        String encryptedDataString = bytesToEncodedString(
                encrypt(encodedStringToBytes(encodedPublicKeyString), stringToBytes(secretText)));
        String decryptedDataString = bytesToString(
                decrypt(
                        encodedStringToBytes(encodedPrivateKeyString),
                        encodedStringToBytes(encryptedDataString)));
        System.out.println(new String(decryptedDataString));
    }
}