class WontCloseBufferedInputStream extends BufferedInputStream {
  public void close () {
    // Do nothing.
  }

  public void reallyClose() {
    super.close ();
  }
}