public interface ByteSerializer {
    ByteSerializer put(byte value);

    ByteSerializer putInt(int value);

    ByteSerializer putLong(long value);

    boolean isSerializing();

    ByteSerializer add(int bytes);

    int position();
}