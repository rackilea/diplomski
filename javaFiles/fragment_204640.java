private void prepWriteBuffer(String mesg) {    
  // fills the buffer from the given string    
  // and prepares it for a channel write    
  writeBuffer.clear();
  byte[] bytes = mesg.getBytes());
  writeBuffer.putInt(bytes.length);    
  writeBuffer.put(bytes);
  writeBuffer.flip();    
 } 


// called needs to remove the channel if it fails, otherwise it will fail forever.
private void channelWrite(SocketChannel channel, ByteBuffer writeBuffer) throws IOException {    
 while(writeBuffer.remaining()>0)
      channel.write(writeBuffer);
 writeBuffer.rewind();
}