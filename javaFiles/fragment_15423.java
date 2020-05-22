public static int readRawVarint32(
  final int firstByte, final InputStream input) throws IOException {
if ((firstByte & 0x80) == 0) {
  return firstByte;
}

int result = firstByte & 0x7f;
int offset = 7;
for (; offset < 32; offset += 7) {
  final int b = input.read();
  if (b == -1) {
    throw InvalidProtocolBufferException.truncatedMessage();
  }
  result |= (b & 0x7f) << offset;
  if ((b & 0x80) == 0) {
    return result;
  }
}
// Keep reading up to 64 bits.
for (; offset < 64; offset += 7) {
  final int b = input.read();
  if (b == -1) {
    throw InvalidProtocolBufferException.truncatedMessage();
  }
  if ((b & 0x80) == 0) {
    return result;
  }
}
throw InvalidProtocolBufferException.malformedVarint();