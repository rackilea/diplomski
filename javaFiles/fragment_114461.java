int chunkSize = 64;
long startingIndex = 55;
byte[] bytesRead = new byte[chunkSize];

RandomAccessFile file = new RandomAccessFile("file.txt", "r");
file.seek(startingIndex);
file.read(bytesRead);
file.close();