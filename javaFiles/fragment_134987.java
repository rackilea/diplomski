import java.security.SecureRandom;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class PBE {

    private static final String salt = "A long, but constant phrase that will be used each time as the salt.";
    private static final int iterations = 2000;
    private static final int keyLength = 256;
    private static final SecureRandom random = new SecureRandom();

    public static void main(String [] args) throws Exception {
        Security.insertProviderAt(new BouncyCastleProvider(), 1);

        String passphrase = "The quick brown fox jumped over the lazy brown dog";
        String plaintext = "hello world";

        Cipher cipher = Cipher.getInstance("AES/CTR/NOPADDING");
        SecretKey key = generateKey(passphrase);
    byte[] iv = new byte[cipher.getBlockSize()];
        random.nextBytes(iv);
        byte [] ciphertext = encrypt(key, iv, plaintext);
        String recoveredPlaintext = decrypt(key, iv, ciphertext);

        System.out.println(recoveredPlaintext);
    }

    private static byte [] encrypt(SecretKey key, byte[] iv, String plaintext) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CTR/NOPADDING");
        cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv), random);
        return cipher.doFinal(plaintext.getBytes());
    }

    private static String decrypt(SecretKey key, byte[] iv, byte [] ciphertext) throws Exception {

        Cipher cipher = Cipher.getInstance("AES/CTR/NOPADDING");
        cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv), random);
        return new String(cipher.doFinal(ciphertext));
    }

    private static SecretKey generateKey(String passphrase) throws Exception {
        PBEKeySpec keySpec = new PBEKeySpec(passphrase.toCharArray(), salt.getBytes(), iterations, keyLength);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWITHSHA256AND256BITAES-CBC-BC");
        return keyFactory.generateSecret(keySpec);
    }