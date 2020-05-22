void copyFile(File source, File destination) throws Exception {
  FileInputStream inputStream = new FileInputStream(source);
  FileOutputStream outputStream = new FileOutputStream(destination);
  int b = -1;
  while ((b = inputStream.read()) != -1) {
    outputStream.write(b);
  }
  inputStream.close();
  outputStream.close();
}