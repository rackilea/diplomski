int n;
int bytesLeft = fileSize;
byte[] buffer = new byte[8192];
while (bytesLeft > 0) {
    int n = bis.read(buffer, 0, Math.min(buffer.length, bytesLeft));
    if (n < 0) {
        throw new EOFException("Expected " + bytesLeft + " more bytes to read");
    }
    bos.write(buffer, 0, n);
    System.out.println("Writing File... ");
    bytesLeft -= n;
    System.out.println(total " bytes left to read");
}