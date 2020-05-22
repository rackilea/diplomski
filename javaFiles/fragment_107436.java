public class BytesToString {
    public static void main(String[] args) throws Exception {
        // array that will contain all the possible byte values
        byte[] bytes = new byte[256];
        for (int i = 0; i < 256; i++) {
            bytes[i] = (byte) (i + Byte.MIN_VALUE);
        }

        // converting to string and back to bytes
        String str = new String(bytes, "ISO-8859-1");
        byte[] newBytes = str.getBytes("ISO-8859-1");

        if (newBytes.length != 256) {
            throw new IllegalStateException("Wrong length");
        }
        boolean mismatchFound = false;
        for (int i = 0; i < 256; i++) {
            if (newBytes[i] != bytes[i]) {
                System.out.println("Mismatch: " + bytes[i] + "->" + newBytes[i]);
                mismatchFound = true;
            }
        }
        System.out.println("Whether a mismatch was found: " + mismatchFound);
    }
}