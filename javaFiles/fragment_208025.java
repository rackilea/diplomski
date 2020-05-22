FileOutputStream outputStream = new FileOutputStream(fileName);
 int bytesRead;
 byte[] buffer = new byte[1024];
 while ((bytesRead = inputStream.read(buffer)) != -1) {
     outputStream.write(buffer, 0, bytesRead);
 }