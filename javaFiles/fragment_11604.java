FileResolver fileResolver = new FileResolver() {

 @Override
 public File resolveFile(String fileName) {
  return new File(fileName);
 }
};