FileInputStream inputFile = new FileInputStream(myFile);
try {
  FileReader reader = new FileReader(inputFile, "UTF-8");
  // Maybe buffer reader and do something with it.
} finally {
  inputFile.close();
}