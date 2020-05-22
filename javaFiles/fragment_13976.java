FileInputStream fileInput = new FileInputStream(file);
try {
  // ...
} finally {
  fileInput.close();
}