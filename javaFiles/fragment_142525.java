public static int bytesToInt(final byte[] array, final int start)
{
     final ByteBuffer buf = ByteBuffer.wrap(array); // big endian by default
     buf.position(start);
     buf.put(array);
     return buf.position(start).getInt();
}