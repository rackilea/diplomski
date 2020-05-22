private byte[] toByteArray(Blob fromImageBlob) {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    try {
      return toByteArrayImpl(fromImageBlob, baos);
    } catch (Exception e) {
    }
    return null;
  }



private byte[] toByteArrayImpl(Blob fromImageBlob, 
      ByteArrayOutputStream baos) throws SQLException, IOException {
    byte buf[] = new byte[4000];
    int dataSize;
    InputStream is = fromImageBlob.getBinaryStream(); 

    try {
      while((dataSize = is.read(buf)) != -1) {
        baos.write(buf, 0, dataSize);
      }    
    } finally {
      if(is != null) {
        is.close();
      }
    }
    return baos.toByteArray();
  }