public ByteContentBody implements ContentBody {
  private String name;
  private byte[] data;

  public ByteContentBody(String name, byte[] data) {
    this.name = name;
    this.data = data;
  }

  public String getFilename(){
    returns name;
  }

  public void writeTo(OutputStream out) throws IOException {
    out.write(data);
  }
}