SeekableByteChannel channel;
ByteBuffer chunkBuffer;

public void open(Path path) {
    channel = Files.newByteChannel(path, EnumSet.of(READ, WRITE, SPARSE)));
    chunkBuffer = ByteBuffer.allocate(Chunk.SIZE);
}

public void close() {
    channel.close();
    chunkBuffer = null;
}

public void write(Chunk chunk) {
    int index = chunkIndex(chunk.getX(), chunk.getY());
    chunkBuffer.clear();
    chunk.saveInto(chunkBuffer);
    chunkBuffer.flip();
    channel.position(HEADER_SIZE + Chunk.SIZE * index);
    channel.write(chunkBuffer);
}

public Chunk read(int x, int y) {
    int index = chunkIndex(x, y);
    chunkBuffer.clear();
    channel.position(HEADER_SIZE + Chunk.SIZE * index);
    if (channel.read(chunkBuffer) < 0) {
        /* end-of-file or chunk at given index not written yet */
        return null;
    } else {
        chunkBuffer.flip();
        return Chunk.loadFrom(chunkBuffer);
    }
}

/** compute linar index of chunk at position x/y */
private int chunkIndex(int x, int y) {
    return y * MAX_CHUNKS_X + x;
}