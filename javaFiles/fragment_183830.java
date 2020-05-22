public void encode64(File input, File output) throws IOException {
    FileInputStream inputStream = new FileInputStream(input);
    FileOutputStream outputStream = new FileOutputStream(output);
    OutputStream encodedStream = Base64.getEncoder().wrap(outputStream);

    byte buff[] = new byte[300];
    int r = 0;
    while ((r = inputStream.read(buff)) > 0) {
      byte[] realBuff = Arrays.copyOf(buff, r);
      encodedStream.write(realBuff);
    }

    inputStream.close();
    encodedStream.close();
}

public void decode64(File input, File output) throws IOException {
  FileInputStream inputStream = new FileInputStream(input);
  FileOutputStream outputStream = new FileOutputStream(output);
  OutputStream decodedStream = Base64.getDecoder().wrap(outputStream);

  byte buff[] = new byte[300];
  int r = 0;
  while ((r = inputStream.read(buff)) > 0) {
    byte[] realBuff = Arrays.copyOf(buff, r);
    decodedStream.write(realBuff);
  }

  inputStream.close();
  decodedStream.close();
}