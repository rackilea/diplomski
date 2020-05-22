import java.security.MessageDigest;
public class Main {
    public static String getHash(byte[] inputBytes, String algorithm) throws Exception{
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.update(inputBytes);
            byte[] digestedBytes = messageDigest.digest();
            return new String(digestedBytes, "UTF-8");
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getHash("The quick brown fox Jumps over the lazy dog".getBytes(), "SHA-384"));
    }
}