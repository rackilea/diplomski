static void encrypt(InputStream is, OneTimePad otp, OutputStream os) throws IOException {
  long index = 0;
  byte[] buffer = new byte[8192];
  while (true) {
    int n = is.read(buffer);
    if (n < 0)
      break;
    for (int i = 0; i < n; ++i)
      buffer[i] ^= otp.get(index++);
    os.write(buffer, 0, n);
  }
}