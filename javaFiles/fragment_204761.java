InputStream stream = socket.getInputStream();
String message = readLineFrom(stream);

int dataSize = getSizeOfBinaryDataSomehow();
int totalBytesRead = 0;
byte[] data = new byte[dataSize];

while (totalBytesRead < dataSize) {
    int bytesRemaining = dataSize - totalBytesRead;
    int bytesRead = stream.read(data, totalBytesRead, bytesRemaining);

    if (bytesRead == -1) {
        return; // socket has been closed
    }

    totalBytesRead += bytesRead;
}