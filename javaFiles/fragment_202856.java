private static Path convert(MultipartFile file) throws IOException {
  Path newFile = Paths.get(file.getOriginalFilename());
  try(InputStream is = file.getInputStream();
     OutputStream os = Files.newOutputStream(newFile))) {
     byte[] buffer = new byte[4096];
     int read = 0;
     while((read = is.read(buffer)) > 0) {
       os.write(buffer,0,read);
     }
  }
  return newFile;  
}