List<ByteBuffer> buffers = super.getBuffers();
if (buffers.stream().allMatch(b -> b.position() > 0)) {
    return OutgoingMessageStatus.FULLY_SENT;
} else if (buffers.stream().noneMatch(b -> b.position() > 0)) {
    return OutgoingMessageStatus.WAS_NOT_SENT;
} else {
    return OutgoingMessageStatus.PARTIALLY_SENT;
}