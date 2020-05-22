byte[] bytes = new byte[512];
   InputStream is = client.getInputStream();
   while (length>0) {
       int read = is.read(bytes, 0, Math.min(bytes.length, length));
       if (read > 0) {
         file.write(bytes, 0, read);
         length-=read;
       }
       if (read < 0)
         throw new IOException("end reached before all data read"; 
   }