FileInputStream src = new FileInputStream(file);
try {
  FileReader bitIn = new FileReader(src);
  ...
} finally {
  src.close();
}