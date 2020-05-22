File file = new File("DemoRandomAccessFile.out");
RandomAccessFile raf = new RandomAccessFile(file, "r");

// Seek to the end of file
raf.seek(file.length() - n);
// Read it out.
raf.read(yourbyteArray, 0, n);