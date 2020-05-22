try(FileChannel ch=new RandomAccessFile("test.stl", "rw").getChannel())
{
  ByteBuffer bb=ByteBuffer.allocate(10000).order(ByteOrder.LITTLE_ENDIAN);
  // ...
  // e.g. store a vertex:
  bb.putFloat(0.0f).putFloat(1.0f).putFloat(42);
  bb.flip();
  ch.write(bb);
  bb.clear();
  // ...
}