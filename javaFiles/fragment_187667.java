public class MyGZIPOutputStream extends GZIPOutputStream {

  public MyGZIPOutputStream(final OutputStream out) throws IOException {
    super(out);
  }

  public void setDictionary(byte[] b) {
    def.setDictionary(b);
  }

}