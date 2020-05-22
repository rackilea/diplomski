ByteBuffer buffer = ByteBuffer.wrap(i);
byte[] headerArr = new byte[12];

while (buffer.hasRemaining()) {

    buffer.get(headerArr);

    int length = buffer.getShort() & 0xffff;
    if (length == 0) {
        break;
    }

    byte[] newArr = new byte[length];
    buffer.get(newArr);

    sendnewArray(headerArr, newArr);
}