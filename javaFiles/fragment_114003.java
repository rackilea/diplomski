import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created for http://stackoverflow.com/q/27670421/1266906.
 */
public class AsyncToStream {
    public static void main(String[] args) {

        System.out.println("Unbuffered Test:");
        AsyncTaskResultIterator<TaskResult> taskListener1 = new AsyncTaskResultIterator<>();
        new TaskResultGenerator(taskListener1, 5).start();
        taskListener1.unbufferedStream().forEach(System.out::println);

        System.out.println("Buffered Test:");
        AsyncTaskResultIterator<TaskResult> taskListener2 = new AsyncTaskResultIterator<>();
        new TaskResultGenerator(taskListener2, 5).start();
        taskListener2.bufferedStream().forEach(System.out::println);
    }

    /**
     * This class wraps a sequence of TaskResults into an iterator upto the first TaskResult where {@code }isLastResult()} returns {@code true}
     */
    public static class AsyncTaskResultIterator<T extends TaskResult> implements Iterator<T>, TaskListener<T> {

        /**
         * This acts as an asynchronous buffer so we can easily wait for the next TaskResult
         */
        private final BlockingQueue<T> blockingQueue;
        /**
         * Becomes {@code true} once {@code TaskResult.isLastResult()} is received
         */
        private       boolean          ended;

        public AsyncTaskResultIterator() {
            blockingQueue = new LinkedBlockingQueue<>();
        }

        /**
         * Waits on a new TaskResult and returns it as long as the previous TaskResult did not specify {@code isLastResult()}. Afterwards no more elements can be retrieved.
         */
        @Override
        public T next() {
            if (ended) {
                throw new NoSuchElementException();
            } else {
                try {
                    T next = blockingQueue.take();
                    ended = next.isLastResult();
                    return next;
                } catch (InterruptedException e) {
                    throw new IllegalStateException("Could not retrieve next value", e);
                }
            }
        }

        @Override
        public boolean hasNext() {
            return !ended;
        }

        /**
         * Enqueue another TaskResult for retrieval
         */
        @Override
        public void onTaskResult(T result) {
            if (ended) {
                throw new IllegalStateException("Already received a TaskResult with isLastResult() == true");
            }
            try {
                blockingQueue.put(result);
            } catch (InterruptedException e) {
                throw new IllegalStateException("Could not enqueue next value", e);
            }
        }

        /**
         * Builds a Stream that acts upon the results just when they become available
         */
        public Stream<T> unbufferedStream() {
            Spliterator<T> spliterator = Spliterators.spliteratorUnknownSize(this, 0);
            return StreamSupport.stream(spliterator, false);
        }

        /**
         * Buffers all results and builds a Stream around the results
         */
        public Stream<T> bufferedStream() {
            Stream.Builder<T> builder = Stream.builder();
            this.forEachRemaining(builder);
            return builder.build();
        }
    }

    public static class TaskResultImpl implements TaskResult {
        private boolean lastResult;
        private String  name;

        public TaskResultImpl(boolean lastResult, String name) {
            this.lastResult = lastResult;
            this.name = name;
        }

        @Override
        public String toString() {
            return "TaskResultImpl{" +
                    "lastResult=" + lastResult +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        public boolean isLastResult() {
            return lastResult;
        }
    }

    public static interface TaskListener<T extends TaskResult> {
        public void onTaskResult(T result);
    }

    public static interface TaskResult {
        boolean isLastResult();
    }

    private static class TaskResultGenerator extends Thread {
        private final TaskListener<TaskResult> taskListener;
        private final int                      count;

        public TaskResultGenerator(TaskListener<TaskResult> taskListener, int count) {
            this.taskListener = taskListener;
            this.count = count;
        }

        @Override
        public void run() {
            try {
                for (int i = 1; i < count; i++) {
                    Thread.sleep(200);
                    taskListener.onTaskResult(new TaskResultImpl(false, String.valueOf(i)));
                }
                Thread.sleep(200);
                taskListener.onTaskResult(new TaskResultImpl(true, String.valueOf(count)));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}