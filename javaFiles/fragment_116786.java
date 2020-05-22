public byte[] getPicture(InputStream in) {
  try {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    byte[] data = new byte[1024];
    int length = 0;
    while ((length = in.read(data))!=-1) {
        out.write(data,0,length);
    }
       return out.toByteArray();
    } catch(IOException ioe) {
    //handle it
   }
   return null;
 }