public T read() throws Exception {
  T o = this.delegateReader.read();
  if (o == null) {
    // Perform deletion here
    deleteFile(this.resource);
  }
  return o;
}