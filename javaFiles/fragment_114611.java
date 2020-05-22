// Assuming new frames are always copied-to-start and that there
// if a complete frame ready (can be determined from frame size with)
// two reads. If not, keep reading..
byte[] receivingBuffer = ..;
int offset = 0;
int seq = receivingBuffer[offset++];
int frameSize = receivingBuffer[offset++];

// Again, use an encoding
String content = new String(receivingBuffer, offset, frameSize, "UTF-8");
offset += frameSize;

int checksum = receivingBuffer[offset++];

// Use offset to move extra data in receivingBuffer to start
// of buffer to make it easy to reset offset to 0 and repeat above.