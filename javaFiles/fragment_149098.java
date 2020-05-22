class SomeUtilClass {
public interface Processor<T> {
    boolean process(Integer byteCount, ByteBuffer buffer);
    T result();
}
public static <T> ListenableFuture<T> read(
    final AsynchronousSocketChannel delegate,
    final Processor<T> processor,
    ByteBuffer buffer
) {
    final SettableFuture<T> resultFuture = SettableFuture.create();
    delegate.read(buffer, buffer, new Handler<T, Integer, ByteBuffer>(resultFuture) {
        public void completed(Integer bytesRead, ByteBuffer buffer) {
            buffer.flip();
            if(processor.process(bytesRead, buffer)) {
                buffer.clear();
                delegate.read(buffer, buffer, this);
            } else {
                resultFuture.set(processor.result());
            }
        }
    });
    return resultFuture;
}
}