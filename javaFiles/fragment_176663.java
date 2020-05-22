public class MutableStringTest {


    // http://stackoverflow.com/questions/11146255/how-to-create-mutable-java-lang-string#11146288
    @Test
    public void testMutableString() throws Exception {
        final String s = createModifiableString();
        System.out.println(s);
        modify(s);
        System.out.println(s);
    }

    private final AtomicReference<CharBuffer> cbRef = new AtomicReference<CharBuffer>();
    private String createModifiableString() {
        Charset charset = new Charset("foo", null) {
            @Override
            public boolean contains(Charset cs) {
                return false;
            }

            @Override
            public CharsetDecoder newDecoder() {
                CharsetDecoder cd = new CharsetDecoder(this, 1.0f, 1.0f) {
                    @Override
                    protected CoderResult decodeLoop(ByteBuffer in, CharBuffer out) {
                        cbRef.set(out);
                        while(in.remaining()>0) {
                            out.append((char)in.get());
                        }
                        return CoderResult.UNDERFLOW;
                    }
                };
                return cd;
            }

            @Override
            public CharsetEncoder newEncoder() {
                return null;
            }
        };
        return new String("abc".getBytes(), charset);
    }
    private void modify(String s) {
        CharBuffer charBuffer = cbRef.get();
        charBuffer.position(0);
        charBuffer.put("xyz");
    }

}