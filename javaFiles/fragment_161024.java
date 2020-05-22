File file = new File(path);
if (file.length() > Integer.MAX_VALUE)
  throw new IllegalArgumentException("File is too large: " + file.length());
int len = (int) file.length();
FileInputStream inputStream = new FileInputStream(file);
try { 
  byte[] fileBits = new byte[len];
  for (int pos = 0; pos < len; ) {
    int n = inputStream.read(fileBits, pos, len - pos);
    if (n < 0)
      throw new EOFException();
    pos += n;
  }
  /* Use bits. */
  ...
} finally {
  inputStream.close();
}