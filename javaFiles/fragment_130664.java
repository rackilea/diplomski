public long countContent(URL urls) {
  try {
     //...
     CountingInputStream counter = new CountingInputStream(httpResponse.getEntity().getContent());
     FileOutputStream os = new FileOutputStream(MEDIA_PATH + "/fileName.mp3");

     int read;
     byte[] buffer = new byte[1028];
     while ((read = counter.read(buffer)) != -1) {
        os.write(buffer, 0, read);
        publishProgress(counter.getByteCount()/size);
     }
     // ...
     return counter.getByteCount()/size;
  } catch (IOException ex) {
     throw new RuntimeException(ex);
  }
}