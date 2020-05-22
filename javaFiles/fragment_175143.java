public class Test {
    public static void main(String[] args) throws CharacterCodingException {
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.putInt(0x80);
        buffer.putInt(0x81);
        buffer.position(0);
        Charset charset = Charset.forName("IBM1098");
        CharsetDecoder decoder = charset.newDecoder();
        decoder.decode(buffer);
    }   
}