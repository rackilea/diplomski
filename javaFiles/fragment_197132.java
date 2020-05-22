byte[] b1 = new byte[BUFFER_SIZE];
int readBytes1;
while ((readBytes1 = is.read(b1)) != -1) {
        writeChannel.write(ByteBuffer.wrap(b1, 0, readBytes));
}
writeChannel.closeFinally();