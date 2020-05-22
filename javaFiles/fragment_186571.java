public class FileStack {
  private File file;
  private long position = 0;
  private String cache = null;

  public FileStack(File file) {
    this.file = file;
  }

  public String peek() throws IOException {
    if (cache != null) {
      return cache;
    }

    BufferedReader r = new BufferedReader(new FileReader(file));
    try {
      r.skip(position);
      cache = r.readLine();
      return cache;
    } finally {
      r.close();
    }
  }

  public String pop() throws IOException {
    String r = peek();
    if (r != null) {
      // if you have \r\n line endings, you may need +2 instead of +1
      // if lines could end either way, you'll need something more complicated
      position += r.length() + 1;
      cache = null;
    }
    return r;
  }
}