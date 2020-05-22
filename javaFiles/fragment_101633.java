package aes;

public class Main {
    static byte[] plaintext = new byte[] {0x41, 0x42, 0x43, 0x44, 0x45, 0x46, 0x47, 0x48, 0x49, 0x4a, 0x4b, 0x4c, 0x4d, 0x4e, 0x4f, 0x50, 0x51, 0x52, 0x53};
    public static void main(String[] args) {
        AES aes = new AES("Random09Random09");

        byte[] encrypted = aes.encrypt(plaintext);
        byte[] decrypted = aes.decrypt(encrypted);  
        System.out.println("Original:\n" + new String(plaintext) + "\nEncrypted:\n" + new String(encrypted) + "\nDecrypted:\n" + new String(decrypted));
    }
}