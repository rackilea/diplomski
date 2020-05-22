public class Driver {
    public static void main(String[] args) {
        String s = "Reversible Hash a String to BigInteger in Java";

        System.out.println(HashUtil.notReallyHash(s));
        System.out.println(HashUtil.notReallyUnhash(HashUtil.notReallyHash(s)));
    }
}

class HashUtil {
    private static final byte SENTINEL = (byte) 1;

    public static BigInteger notReallyHash(String s) {
        CharBuffer charBuf = CharBuffer.wrap(s.toCharArray());
        ByteBuffer byteBuf = ByteBuffer.allocate(charBuf.length() * Character.BYTES + 1);

        byteBuf.put(SENTINEL); // need this in case first byte is 0 - biginteger will drop it
        byteBuf.asCharBuffer()
               .append(charBuf);

        return new BigInteger(1, byteBuf.array());
    }

    public static String notReallyUnhash(BigInteger bi) {
        ByteBuffer byteBuf = ByteBuffer.wrap(bi.toByteArray());

        byteBuf.get(); // SENTINEL

        CharBuffer charBuf = byteBuf.asCharBuffer();

        StringBuilder sb = new StringBuilder();

        int count = charBuf.length();
        for (int i = 0; i < count; i++) {
            sb.append(charBuf.get());
        }

        return sb.toString();
    }
}