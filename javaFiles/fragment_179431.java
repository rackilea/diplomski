synchronize (lock) {
    int originalPosition = dstBuffer.position();
    dstBuffer.position(desiredPosition);
    dstBuffer.put(srcBuffer);
    dstBuffer.position(originalPosition);
}