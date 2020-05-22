@SafeVarargs
public static <T> long streamForked(Stream<T> source, Consumer<Stream<T>>... consumers)
{
    return StreamSupport.stream(new ForkingSpliterator<>(source, consumers), false).count();
}

public static class ForkingSpliterator<T>
    extends AbstractSpliterator<T>
{
    private Spliterator<T>         sourceSpliterator;

    private List<BlockingQueue<T>> queues = new ArrayList<>();

    private boolean                sourceDone;

    @SafeVarargs
    private ForkingSpliterator(Stream<T> source, Consumer<Stream<T>>... consumers)
    {
        super(Long.MAX_VALUE, 0);

        sourceSpliterator = source.spliterator();

        for (Consumer<Stream<T>> fork : consumers)
        {
            LinkedBlockingQueue<T> queue = new LinkedBlockingQueue<>();
            queues.add(queue);
            new Thread(() -> fork.accept(StreamSupport.stream(new ForkedConsumer(queue), false))).start();
        }
    }

    @Override
    public boolean tryAdvance(Consumer<? super T> action)
    {
        sourceDone = !sourceSpliterator.tryAdvance(t -> queues.forEach(queue -> queue.offer(t)));
        return !sourceDone;
    }

    private class ForkedConsumer
        extends AbstractSpliterator<T>
    {
        private BlockingQueue<T> queue;

        private ForkedConsumer(BlockingQueue<T> queue)
        {
            super(Long.MAX_VALUE, 0);
            this.queue = queue;
        }

        @Override
        public boolean tryAdvance(Consumer<? super T> action)
        {
            while (queue.peek() == null)
            {
                if (sourceDone)
                {
                    // element is null, and there won't be no more, so "terminate" this sub stream
                    return false;
                }
            }

            // push to consumer pipeline
            action.accept(queue.poll());

            return true;
        }
    }
}