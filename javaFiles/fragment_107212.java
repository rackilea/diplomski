int read;
byte[] finalBuf = new byte[0], swapBuf;
byte[] readBuffer = new byte[5012];

ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(
        compressed);
InflaterInputStream inputStream = new InflaterInputStream(
        arrayInputStream);
while ((read = inputStream.read(readBuffer)) != -1) {
    System.out.println("Intermediate read: " + read);
    swapBuf = finalBuf;
    finalBuf = new byte[swapBuf.length + read];
    System.arraycopy(swapBuf, 0, finalBuf, 0, swapBuf.length);
    System.arraycopy(readBuffer, 0, finalBuf, swapBuf.length, read);
}