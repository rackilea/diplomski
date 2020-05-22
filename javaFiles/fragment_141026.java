public void setOutputStream(OutputStream out){
  io.setOutputStream(out, false);
}

public InputStream getInputStream() throws IOException {
  int max_input_buffer_size = 32*1024;
  try {
    max_input_buffer_size =
      Integer.parseInt(getSession().getConfig("max_input_buffer_size"));
  }
  catch(Exception e){}
  PipedInputStream in =
    new MyPipedInputStream(
                           32*1024,  // this value should be customizable.
                           max_input_buffer_size
                           );
  boolean resizable = 32*1024<max_input_buffer_size;
  io.setOutputStream(new PassiveOutputStream(in, resizable), false);
  return in;
}