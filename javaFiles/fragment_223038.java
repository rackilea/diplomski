import static java.nio.charset.StandardCharsets.UTF_8;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

public class PasswordVault {
    private static final int KEY_SIZE_BITS = 128;
    private static final int GCM_TAG_SIZE_BITS = 128;
    private static final int GCM_IV_SIZE_BYTES = 12;
    private ArrayList<PasswordEntry> vaultBoxes;
    private SecretKey key;

    public PasswordVault() throws NoSuchAlgorithmException {
        vaultBoxes = new ArrayList<>();
        key = generateKey();
    }

    public void encryptAndStorePasswordEntry(PasswordEntry passwordEntry) throws GeneralSecurityException {
        String encryptedPassword = encrypt(passwordEntry.getPassword(), key);
        PasswordEntry savePass = new PasswordEntry(passwordEntry.getWebsite(), passwordEntry.getLogin(),
                encryptedPassword);
        vaultBoxes.add(savePass);
    }

    public PasswordEntry retrieveAndDecryptPasswordEntry() throws GeneralSecurityException {
        // TODO think of a way to retrieve the password for a specific entry
        PasswordEntry encryptedPasswordEntry = vaultBoxes.get(0);
        String password = decrypt(encryptedPasswordEntry.getPassword(), key);
        return new PasswordEntry(encryptedPasswordEntry.getWebsite(), encryptedPasswordEntry.getLogin(), password);
    }

    public static SecretKey generateKey() throws NoSuchAlgorithmException {
        SecureRandom random = SecureRandom.getInstanceStrong();
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(KEY_SIZE_BITS, random);
        return keyGen.generateKey();
    }

    public static String encrypt(String password, SecretKey key) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");

        byte[] iv = generateRandomIV();

        GCMParameterSpec spec = new GCMParameterSpec(GCM_TAG_SIZE_BITS, iv);
        cipher.init(Cipher.ENCRYPT_MODE, key, spec);

        byte[] bytePassword = password.getBytes(UTF_8);
        byte[] ivCTAndTag = new byte[GCM_IV_SIZE_BYTES + cipher.getOutputSize(bytePassword.length)];
        System.arraycopy(iv, 0, ivCTAndTag, 0, GCM_IV_SIZE_BYTES);

        cipher.doFinal(bytePassword, 0, bytePassword.length, ivCTAndTag, GCM_IV_SIZE_BYTES);

        return Base64.getEncoder().encodeToString(ivCTAndTag);
    }

    private static byte[] generateRandomIV() {
        byte[] iv = new byte[GCM_IV_SIZE_BYTES];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);
        return iv;
    }

    public static String decrypt(String encryptedPassword, SecretKey key) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");

        byte[] ivAndCTWithTag = Base64.getDecoder().decode(encryptedPassword);

        GCMParameterSpec spec = new GCMParameterSpec(GCM_TAG_SIZE_BITS, ivAndCTWithTag, 0, GCM_IV_SIZE_BYTES);
        cipher.init(Cipher.DECRYPT_MODE, key, spec);

        byte[] plaintext = cipher.doFinal(ivAndCTWithTag, GCM_IV_SIZE_BYTES, ivAndCTWithTag.length - GCM_IV_SIZE_BYTES);

        return new String(plaintext, UTF_8);
    }

    public static void main(String[] args) throws Exception {
        PasswordVault vault = new PasswordVault();
        PasswordEntry passwordEntry = readPlainPasswordEntry();
        vault.encryptAndStorePasswordEntry(passwordEntry);
        System.out.println(vault.vaultBoxes);
        PasswordEntry decryptedPasswordEntry = vault.retrieveAndDecryptPasswordEntry();
        System.out.println(decryptedPasswordEntry);
    }

    public static PasswordEntry readPlainPasswordEntry() {
        try (Scanner keyboard = new Scanner(System.in)) {
            System.out.println("Please enter in the website that you would like to store a password:");
            String website = keyboard.nextLine();
            System.out.println("Please enter your username");
            String login = keyboard.nextLine();
            System.out.println("Please enter your password");
            String password = keyboard.nextLine();

            return new PasswordEntry(website, login, password);
        }
    }
}