public static byte[] readFileSegment(File file, long index, int count) {
    RandomAccessFile raf = new RandomAccessFile(file, "r");
    byte[] buffer = new byte[count];
    try {
        raf.seek(index);
        raf.readFully(buffer, 0, count);
        return buffer;
    } finally {
        raf.close();
    }
}