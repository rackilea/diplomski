ByteBuffer[] segments = message.getSegmentsForOutput();
int total = (segments.length / 2 + 1) * 8;  // segment table
for (ByteBuffer segment: segments) {
  total += segment.remaining();
}
// now `total` is the total number of bytes that will be
// written when the message is serialized.