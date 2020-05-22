public byte[] readPacket(InputStream in) throws IOException {
     ByteArrayOutputStream tempStr = new ByteArrayOutputStream();
     int read;
     read=in.read();
     while(read > 0){
       tempStr.write(read);
       read=in.read();
       }
     if(read == -1)
         throw new EOFException();
     return tempStr.toByteArray();
}