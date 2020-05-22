class FileReader {

  private final InputStream src;

  private final byte[] bits = new byte[8192];

  private int len;

  private int pos;

  FileReader(InputStream src) { 
    this.src = src; 
  }

  int readBit() throws IOException {
    int idx = pos / 8;
    if (idx >= len) {
      int n = src.read(bits);
      if (n < 0)
        return -1;
      len = n;
      pos = 0;
      idx = 0;
    }
    return ((bits[idx] & (1 << (pos++ % 8))) == 0) ? 0 : 1;
  }

}