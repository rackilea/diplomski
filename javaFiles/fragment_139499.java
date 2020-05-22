// CLIENT
private Socket socket; // initialized somewhere
private static final byte[] STOP = "</COMMS>".getBytes();
private static final int BUFFER_SIZE = 1024 << 8;
private InputStream in;

public byte[] receiveData(){
    if(in == null){
      in = socket.getInputStream();
    }
    byte[] content;
    byte[] bytes = new byte[BUFFER_SIZE];
    int bytesRead;
    while((bytesRead = in.read(bytes)) != -1){  // normal termination
          if(receivedStop(bytes,bytesRead)){  // see if stopped
               removeStopBytes(bytes,bytesRead); // get rid of the STOP bytes
               content = buildContent(content,bytes,bytesRead); // transfer bytes to array
               break;
          }
          content = buildContent(content,bytes,bytesRead); // transfer bytes to array
    }
    return content;
}