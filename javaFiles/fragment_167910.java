public class CustomLengthFieldBasedFrameDecoder extends LengthFieldBasedFrameDecoder {
  @Override
  protected long getUnadjustedFrameLength(ByteBuf buf, int offset, int length, ByteOrder order) {
    buf = buf.order(order);
    byte[] lengthBytes = new Byte[length];
    buf.getBytes(offset, lengthBytes);
    String s = new String(lengthBytes, CharsetUtil.US_ASCII);
    return Long.parseLong(s);
  }
}