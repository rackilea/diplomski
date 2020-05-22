long totalReceived = 0;
int bufferSize = 4096;
byte[] buffer = new byte[bufferSize];
while (totalReceived < fileSize) {
    int bytesRead = inputStream.read(buffer);
    fileOutputStream.write(buffer, 0, bytesRead);
    fileOutputStream.flush();
    totalReceived += bytesRead;
}