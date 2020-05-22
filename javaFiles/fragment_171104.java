import java.util.Comparator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public  class OuterJoinSpliterator<T> extends Spliterators.AbstractSpliterator<Element<T>> {

    private final class Filler implements Runnable {
        private final Stream<Element<T>> stream;
        private final BlockingQueue<Element<T>> queue;

        private Filler(Stream<Element<T>> stream, BlockingQueue<Element<T>> queue) {
            this.stream = stream;
            this.queue = queue;
        }

        @Override
        public void run() {
            stream.forEach(x -> {
                try {
                    queue.put(x);
                } catch (final InterruptedException e) {
                    e.printStackTrace();
                }
            });
            try {
                queue.put(EOS);
            } catch (final InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public final Element<T> EOS = new Element<T>();
    private final int queueSize;
    private final BlockingQueue<Element<T>> leftQueue;
    private final BlockingQueue<Element<T>> rightQueue;
    protected Element<T> leftValue;
    protected Element<T> rightValue;

    private OuterJoinSpliterator(long estSize, int characteristics, int queueSize,
            Stream<Element<T>> leftStream, Stream<Element<T>> rightStream) {
        super(estSize, characteristics);
        this.queueSize = queueSize;
        leftQueue = createQueue();
        rightQueue = createQueue();
        createFillerThread(leftStream, leftQueue).start();
        createFillerThread(rightStream, rightQueue).start();
    }

    private Element<T> acceptBoth(long id, Element<T> left, Element<T> right) {
        return new Element<T>(id, left, right);
    }

    private final Element<T> acceptLeft(Element<T> left) {
        return acceptBoth(left.id, left, null);
    }

    private final Element<T> acceptRight(Element<T> right) {
        return acceptBoth(right.id, null, right);
    }

    private final Thread createFillerThread(Stream<Element<T>> leftStream, BlockingQueue<Element<T>> queue) {
        return new Thread(new Filler(leftStream, queue));
    }

    private final ArrayBlockingQueue<Element<T>> createQueue() {
        return new ArrayBlockingQueue<>(queueSize);
    }

    @Override
    public Comparator<? super Element<T>> getComparator() {
        return null;
    }

    private final boolean isFinished() {
        return leftValue == EOS && rightValue == EOS;
    }

    @Override
    public final boolean tryAdvance(Consumer<? super Element<T>> action) {
        try {
            updateLeft();

            updateRight();

            if (isFinished()) {
                return false;
            }

            if (leftValue == EOS) {
                action.accept(acceptRight(rightValue));
                rightValue = null;
            } else if (rightValue == EOS) {
                action.accept(acceptLeft(leftValue));
                leftValue = null;
            } else {
                switch (leftValue.compareTo(rightValue)) {
                case -1:
                    action.accept(acceptLeft(leftValue));
                    leftValue = null;
                    break;
                case 1:
                    action.accept(acceptRight(rightValue));
                    rightValue = null;
                    break;
                default:
                    action.accept(acceptBoth(leftValue.id, leftValue, rightValue));
                    leftValue = null;
                    rightValue = null;
                }
            }
        } catch (final InterruptedException e) {
            return false;
        }
        return true;
    }

    private final void updateLeft() throws InterruptedException {
        if (leftValue == null) {
            leftValue = leftQueue.take();
        }
    }

    private final void updateRight() throws InterruptedException {
        if (rightValue == null) {
            rightValue = rightQueue.take();
        }
    }

    public static <T> Stream<Element<T>> join(long estSize, int characteristics, int queueSize, boolean parallel, Stream<Element<T>> leftStream, Stream<Element<T>> rightStream) {
        Spliterator<Element<T>> spliterator = new OuterJoinSpliterator<>(estSize, characteristics, queueSize, leftStream, rightStream);
        return StreamSupport.stream(spliterator, parallel);
    }
}