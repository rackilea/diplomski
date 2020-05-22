public class Encoding {

    public static void main(String[] args) {
        // Cp1252 is Windows codepage 1252
        byte[] bytes = "ÅÛ–ßÕÅÝ•ÞÃ".getBytes(Charset.forName("Cp1252"));
        for (byte b: bytes) {
            System.out.println(b & 255);
        }
    }

}