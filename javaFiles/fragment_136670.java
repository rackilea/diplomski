byte[] data = //From UDP socket
ByteBuffer bb = ByteBuffer.wrap(data);
bb = bb.order(ByteOrder.LITTLE_ENDIAN);

while(bb.hasRemaining()){
    short s = bb.getShort();
    int n = 0xFFFF & s;
    ...
}