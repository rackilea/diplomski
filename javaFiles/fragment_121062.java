int byteCount = inputStream.read(buffer);
while (byteCount >= 0) {
     fileOutputStream.write(buffer, 0, byteCount);
     counter = byteCount + counter;
     percentage = byteCount / contentLength;
     byteCount = inputStream.read(buffer);
}