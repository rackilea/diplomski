byte[] buffer = new byte[8 * 1024];

InputStream input = urlConnect.getInputStream();
try {
  OutputStream output = new FileOutputStream(filename);
  try {
    int bytesRead;
    while ((bytesRead = input.read(buffer)) != -1) {
      output.write(buffer, 0, bytesRead);
    }
  } finally {
    output.close();
  }
} finally {
  input.close();
}