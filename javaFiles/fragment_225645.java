import java.nio.charset.Charset;

class Test {
    public static void main(String[] args) throws Exception {
        String pound = "\u00a3";
        byte[] bytes = pound.getBytes(Charset.forName("UTF-8"));
        for (byte b : bytes) {
            System.out.println(b & 0xff); // 194, 163
        }
    }
}