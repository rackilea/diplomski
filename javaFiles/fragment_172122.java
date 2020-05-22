public static byte[] readPortion(File file, int offset, int length)
    throws IOException {
  byte[] data = new byte[length];
  try (RandomAccessFile raf = new RandomAccessFile(file)) {
    raf.seek(offset);
    raf.readFully(data);
  }
  return data;
}