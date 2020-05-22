public class Cryptography {

    private static byte[] key = "01234567890123456789012345678901".getBytes(StandardCharsets.UTF_8);
    private static byte[] iv  = "0123456789012345".getBytes(StandardCharsets.UTF_8);

    public static void main(String[] args) throws Exception {       
        String plainText = "This is a plain text which needs to be encrypted...";
        String encrypedData = encrypt(plainText.getBytes(StandardCharsets.UTF_8));
        System.out.println(encrypedData);
        byte[] decryptedData = decrypt(encrypedData);
        String decryptedText = new String(decryptedData, StandardCharsets.UTF_8);
        System.out.println(decryptedText);      
    }
    ...
}