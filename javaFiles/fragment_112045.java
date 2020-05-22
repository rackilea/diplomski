String fileName = "hello.txt";
final int chunkSize = 256;
List<ByteBuffer> bufferList = new ArrayList<>();
Path path = Paths.get(fileName);
try (SeekableByteChannel inChannel = Files.newByteChannel(path,
        EnumSet.of(StandardOpenOption.READ))) {
    long size = inChannel.size();
    while (size > 0) {
        ByteBuffer buffer = ByteBuffer.allocate(chunkSize);

        int nread = inChannel.read(buffer);
        if (nread <= 0) {
            break;
        }
        buffer.flip();
        bufferList.add(buffer);
        size -= nread;
    }
}

// write
Path file1 = Paths.get("hello2.txt") ;
try (SeekableByteChannel outChannel = Files.newByteChannel(file1,
        EnumSet.of(StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE))) {
    for (ByteBuffer buffer : bufferList) {
        int nwritten = outChannel.write(buffer);
    }
}