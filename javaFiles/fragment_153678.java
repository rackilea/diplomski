public static void writeTo(MediaSource source, OutputStream outputStream)
        throws IOException {

      InputStream sourceStream = source.getInputStream();
      BufferedOutputStream bos = new BufferedOutputStream(outputStream);
      BufferedInputStream bis = new BufferedInputStream(sourceStream);
      long byteCounter = 0L; 

      try {
        byte [] buf = new byte[2048]; // Transfer in 2k chunks
        int bytesRead = 0;
        while ((bytesRead = bis.read(buf, 0, buf.length)) >= 0) {
          // byte counter
          byteCounter += bytesRead;
          bos.write(buf, 0, bytesRead); 
        }
        bos.flush();
      } finally {
        bis.close();
      }
    }
  }