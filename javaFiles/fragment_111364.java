public class ByteTest {
    private static final String CHARSET = "ISO-8859-1";

    @Test
    public void test() throws UnsupportedEncodingException {
        byte b = (byte) (220);
        String s = new String(new byte[] { b }, CHARSET);
        byte[] parsed = s.getBytes(CHARSET);
        assertEquals(b, parsed[0]);
    }
}