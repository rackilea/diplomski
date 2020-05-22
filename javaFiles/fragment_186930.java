byte[] buffer = new byte[1024];
int bytesLeft = 5 * 1024 * 1024; // Or whatever
FileInputStream fis = new FileInputStream(input);
try {
  FileOutputStream fos = new FileOutputStream(output);
  try {
    while (bytesLeft > 0) {
      int read = fis.read(buffer, 0, Math.min(bytesLeft, buffer.length);
      if (read == -1) {
        throw new EOFException("Unexpected end of data");
      }
      fos.write(buffer, 0, read);
      bytesLeft -= read;
    }
  } finally {
    fos.close(); // Or use Guava's Closeables.closeQuietly,
                 // or try-with-resources in Java 7
  }
} finally {
  fis.close(); 
}