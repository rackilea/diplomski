package some.package;

final class ByteBufferGuard {
    @FunctionalInterface
    static interface BufferCleaner {
        void freeBuffer(String resourceDescription, ByteBuffer b) throws IOException;
    }
}