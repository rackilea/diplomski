final int targetLength = theNewArray.length + offset;
final boolean overflow = targetLength > theOriginalArray.length;
final ByteBuffer buf;

if (overflow) {
    buf = ByteBuffer.allocate(targetLength);
    buf.put(theOriginalArray);
    buf.rewind();
} else
    buf = ByteBuffer.wrap(theOriginalArray);

buf.position(offset);
buf.put(theNewArray);

return buf.array(); // IMPORTANT