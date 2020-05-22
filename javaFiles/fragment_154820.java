public static byte[] readAllBytes(Path path) throws IOException {
    try (SeekableByteChannel sbc = Files.newByteChannel(path);
         InputStream in = Channels.newInputStream(sbc)) {
        long size = sbc.size();
        if (size > (long)MAX_BUFFER_SIZE)
            throw new OutOfMemoryError("Required array size too large");

        return read(in, (int)size);
    }
}