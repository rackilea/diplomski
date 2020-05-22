byte[] readBuffer = new byte[20];

while (inputStream.available() > 0) {
    int numBytes = inputStream.read(readBuffer);
    System.out.print(new String(readBuffer, 0, numBytes, "us-ascii"));
}