byte[] b = new byte[BUFSIZE];
int chunkSize;
while(true) {
  try {
    while( (chunkSize = is.read(b)) != -1) {
      os.write(b, 0, chunkSize);
      os.flush();
    }
  } catch (IOException ex) {
    Logger.getLogger(socketProducer.class.getName()).log(Level.SEVERE, null, ex);
  }
}