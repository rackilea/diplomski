int bytesRead = 0;
while((bytesRead = bin.read(buf)) != -1) {
  bout.write(buf, 0, bytesRead); // Write only the bytes read
  total += bytesRead;
  // ...
}