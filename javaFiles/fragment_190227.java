private static funal int CHUNK_SIZE = 200;

.....

int currentIndex = 0;
int size = data.length; 
while (currentIndex < size) {
    int currentLength = Math.Min(size-currentIndex, CHUNK_SIZE);
    memOutStream.write(data, currentIndex, currentLength);
    currentIndex += currentLength; 
}