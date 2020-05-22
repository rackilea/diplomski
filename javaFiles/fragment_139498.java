// SERVER
private Socket socket; // initialized somewhere

private static final byte[] STOP = "</COMMS>".getBytes();

public void sendData(byte[] bytes) throws IOException{

  OutputStream out = socket.getOutputStream();

  if(bytes != null){
      out.write(bytes,0,bytes.length);
  }

  out.write(STOP);
}  // notice we exit the method without closing the stream.