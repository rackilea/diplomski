File file = new File("C:\\my_file.txt");
byte[] byteFile = new byte[(int) file.length()];

try {
  FileInputStream fileInputStream = new FileInputStream(file);
  fileInputStream.read(byteFile);
  fileInputStream.close();
} catch (Exception e) {
  //Handle the error
}