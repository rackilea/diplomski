byte[] buffer = new byte[500];
int totalRead = 0;
while (totalRead < buffer.length) {
    // Pass in an offset and length, so we can keep reading into the
    // next part of the array.
    int bytesRead = input.read(buffer, totalRead, buffer.length - totalRead);
    if (bytesRead == -1) {
        throw new EOFException(); // Or whatever... stream ended early
    }
    totalRead += bytesRead;
}