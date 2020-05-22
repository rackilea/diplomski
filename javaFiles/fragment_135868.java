class MyInputStream extends InputStream {

  InputStream original = null;

  public MyInputStream(InputStream original) {
    this.original = original;
  }

  @Override
  public int read() throws IOException {
    int c = original.read();
    System.out.printf("%c", c);
    return c;
  }
}