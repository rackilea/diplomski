int payloadSize = ((payload[0] & 0xFF) << 8) | ((payload[1]) & 0xFF);
byte[] messageBytes = new byte[payloadSize];

int bytesRead = 0;
while (bytesRead < payloadSize) {
   bytesRead += gzipInputStream.read(messageBytes, bytesRead, payloadSize - bytesRead);
}