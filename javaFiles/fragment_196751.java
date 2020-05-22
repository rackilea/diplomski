public class Bytes {
  public static DataInput littleEndian(final DataInput decorated) {
    class LittleInput implements DataInput {
      private ByteBuffer buffer = ByteBuffer.allocate(8);

      public int readInt() throws IOException {
        buffer.clear();
        buffer.order(ByteOrder.BIG_ENDIAN)
            .putInt(decorated.readInt())
            .flip();
        return buffer.order(ByteOrder.LITTLE_ENDIAN)
            .getInt();
      }

      //TODO: other methods    
    }

    return new LittleInput();
  }

}