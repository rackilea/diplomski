import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;

import com.google.common.base.Throwables;
import com.google.common.collect.AbstractIterator;
import com.google.common.util.concurrent.Executors;

public abstract class Iterators2 {
    public static <E> Iterator<E> buffer(final Iterator<E>      source,
                                         int                    capacity) {
        return buffer(source, capacity, defaultExecutor);
    }

    public static <E> Iterator<E> buffer(final Iterator<E>      source,
                                         int                    capacity,
                                         final ExecutorService  exec) {
        if (capacity <= 0) return source;
        final BlockingQueue<E> queue = new ArrayBlockingQueue<E>(capacity);

        // Temporary storage for an element we fetched but could not fit in the queue
        final AtomicReference<E> overflow = new AtomicReference<E>();
        final Runnable inserter = new Runnable() {
            @SuppressWarnings("unchecked")
            public void run() {
                E next = (E) END_MARKER;
                if (source.hasNext()) {
                    next = source.next();
                    // ArrayBlockingQueue does not allow nulls
                    if (next == null) next = (E) NULL_MARKER;
                }
                if (queue.offer(next)) {
                    // Keep buffering elements as long as we can
                    if (next != END_MARKER) exec.submit(this);
                } else {
                    // Save the element.  This also signals to the
                    // iterator that the inserter thread is blocked.
                    overflow.lazySet(next);
                }
            }
        };
        // Fetch the first element.
        // The inserter will resubmit itself as necessary to fetch more elements.
        exec.submit(inserter);
        Iterator<E> iterator = new AbstractIterator<E>() {
            protected E computeNext() {
                try {
                    E next = queue.take();
                    E overflowElem = overflow.getAndSet(null);
                    if (overflowElem != null) {
                        // There is now a space in the queue
                        queue.put(overflowElem);
                        // Awaken the inserter thread
                        exec.submit(inserter);
                    }
                    if (next == END_MARKER) {
                        return endOfData();
                    } else if (next == NULL_MARKER) {
                        return null;
                    } else {
                        return next;
                    }
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    return endOfData();
                }
            }
        };

        return iterator;
    }

    protected Iterators2() {
        throw Throwables.propagate(new InstantiationException(Iterators2.class + " is a static class and cannot be instantiated"));
    }

    private static ExecutorService defaultExecutor =
        java.util.concurrent.Executors.newCachedThreadPool(Executors.daemonThreadFactory());

    private static final Object END_MARKER = new Object();

    private static final Object NULL_MARKER = new Object();
}