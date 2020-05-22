byte[] lengthArray = new byte [someSize]; 
    this.in.readFully(lengthArray, 0, 4); 
    this.busy = true; 
    ByteBuffer lengthBuffer = ByteBuffer.wrap(lengthArray);
    byte[] tcpArray = new byte[length]; 
    // read message from the remote parent peer of this instance
    this.in.readFully(tcpArray, 0, length); 
    // load message into ByteBuffer container for convenience 
    ByteBuffer tcpInput = ByteBuffer.wrap(tcpArray);