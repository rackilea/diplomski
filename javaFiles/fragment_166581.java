File f = new File("test.txt");
try (RandomAccessFile raf = new RandomAccessFile(f, "rw")) {
  FileChannel ch = raf.getChannel();
  MappedByteBuffer buf = ch.map(MapMode.READ_WRITE, 0, f.length());
  final byte[] src = new byte[10];
  System.out.println(src.length > f.length());
  buf.put(src);
}