import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.function.Consumer;
import java.util.function.Function;

public class ByteBufferPool {
    private final int bufferCapacity;
    private final LinkedBlockingDeque<ByteBuffer> queue;

    public ByteBufferPool(int limit, int bufferCapacity) {
        if (limit < 0) throw new IllegalArgumentException("limit must not be negative.");
        if (bufferCapacity < 0) throw new IllegalArgumentException("bufferCapacity must not be negative.");

        this.bufferCapacity = bufferCapacity;
        this.queue = (limit == 0) ? null : new LinkedBlockingDeque<>(limit);
    }

    public ByteBuffer acquire() {
        ByteBuffer buffer = (queue == null) ? null : queue.pollFirst();
        if (buffer == null) {
            buffer = ByteBuffer.allocate(bufferCapacity);
        }
        else {
            buffer.clear();
            buffer.order(ByteOrder.BIG_ENDIAN);
        }
        return buffer;
    }

    public boolean release(ByteBuffer buffer) {
        if (buffer == null) throw new IllegalArgumentException("buffer must not be null.");
        if (buffer.capacity() != bufferCapacity) throw new IllegalArgumentException("buffer has unsupported capacity.");
        if (buffer.isDirect()) throw new IllegalArgumentException("buffer must not be direct.");
        if (buffer.isReadOnly()) throw new IllegalArgumentException("buffer must not be read-only.");

        return (queue == null) ? false : queue.offerFirst(buffer);
    }

    public void withBuffer(Consumer<ByteBuffer> action) {
        if (action == null) throw new IllegalArgumentException("action must not be null.");

        ByteBuffer buffer = acquire();
        try {
            action.accept(buffer);
        }
        finally {
            release(buffer);
        }
    }

    public <T> T withBuffer(Function<ByteBuffer, T> function) {
        if (function == null) throw new IllegalArgumentException("function must not be null.");

        ByteBuffer buffer = acquire();
        try {
            return function.apply(buffer);
        }
        finally {
            release(buffer);
        }
    }

    public <T> CompletionStage<T> withBufferAsync(Function<ByteBuffer, CompletionStage<T>> asyncFunction) {
        if (asyncFunction == null) throw new IllegalArgumentException("asyncFunction must not be null.");

        ByteBuffer buffer = acquire();
        CompletionStage<T> future = null;
        try {
            future = asyncFunction.apply(buffer);
        }
        finally {
            if (future == null) {
                release(buffer);
            }
            else {
                future = future.whenComplete((result, throwable) -> release(buffer));
            }
        }
        return future;
    }
}