private static Dimension getTiffDimensions(InputStream tiffFile) throws IOException {
    ReadableByteChannel channel = Channels.newChannel(tiffFile);

    ByteBuffer buffer = ByteBuffer.allocate(12);

    forceRead(channel, buffer, 8);
    byte endian = buffer.get();
    if(endian != buffer.get() || (endian != 'I' && endian != 'M')) {
        throw new IOException("Not a tiff file.");
    }

    buffer.order(endian == 'I' ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
    if(buffer.getShort() != 42) {
        throw new IOException("Not a tiff file.");
    }

    // Jump to the first image directory. Note that we've already read 8 bytes.
    tiffFile.skip(buffer.getInt() - 8);

    int width = -1;
    int height = -1;
    // The first two bytes of the IFD are the number of fields.
    forceRead(channel, buffer, 2);
    for(int fieldCount = buffer.getShort(); fieldCount > 0 && (width < 0 || height < 0); --fieldCount) {
        forceRead(channel, buffer, 12);
        switch(buffer.getShort()) {
        case 0x0100: // Image width
            width = readField(buffer);
            break;
        case 0x0101: // Image "length", i.e. height
            height = readField(buffer);
            break;
        }
    }
    return new Dimension(width, height);
}

private static void forceRead(ReadableByteChannel channel, ByteBuffer buffer, int n) throws IOException {
    buffer.position(0);
    buffer.limit(n);

    while(buffer.hasRemaining()) {
        channel.read(buffer);
    }
    buffer.flip();
}

private static int readField(ByteBuffer buffer) {
    int type = buffer.getShort();
    int count = buffer.getInt();

    if(count != 1) {
        throw new RuntimeException("Expected a count of 1 for the given field.");
    }

    switch(type) {
    case 3: // word
        return buffer.getShort();
    case 4: // int
        return buffer.getInt();
    default: // char (not used here)
        return buffer.get() & 0xFF;
    }
}