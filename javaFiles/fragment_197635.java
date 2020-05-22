int read(InputStream in) throws IOException {
  int b; 
  while ((b=in.read()) == -1) { 
    try { Thread.sleep(10); } catch (InterruptedException e) { }
  }
  return b;
}