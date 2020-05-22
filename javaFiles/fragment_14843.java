public class DisruptorMPSCQueue<T extends ICopyable<T>> {

    private final RingBuffer<T> ringBuffer;
    private final EventPoller<T> eventPoller;
    private T tempPolledEvent;

    private EventPoller.Handler<T> pollerHandler = new EventPoller.Handler<T>() {
        @Override
        public boolean onEvent(final T event, final long sequence, final boolean endOfBatch) throws Exception {
            tempPolledEvent.copyFrom(event);
            return false;
        }
    };

    public DisruptorMPSCQueue(EventFactory<T> typeConstructor, int size) {
        ringBuffer = RingBuffer.createMultiProducer(typeConstructor, size);
        eventPoller = ringBuffer.newPoller();
        ringBuffer.addGatingSequences(eventPoller.getSequence());
    }

    /**
     * Blocking, can be called from any thread, the event will be copied to the ringBuffer
     */
    public void put(final T event) {
        long sequence = ringBuffer.next(); // blocked by ringBuffer's gatingSequence
        ringBuffer.get(sequence).copyFrom(event);
        ringBuffer.publish(sequence);
    }

    /**
     * Not blocking, can be called from any thread, the event will be copied to the ringBuffer
     *
     * @throws IllegalStateException if the element cannot be added at this time due to capacity restrictions
     */
    public void offer(final T event) {
        long sequence;
        try {
            sequence = ringBuffer.tryNext();
        } catch (InsufficientCapacityException e) {
            throw new IllegalStateException(e); // to mimic blockingQueue
        }
        ringBuffer.get(sequence).copyFrom(event);
        ringBuffer.publish(sequence);
    }

    /**
     * Retrieve top of the queue(removes from the queue). NOT thread-safe, can be called from one thread only.
     *
     * @param destination top of the queue will be copied to destination
     * @return destination object or null if the queue is empty
     */
    public T poll(final T destination) {
        try {
            tempPolledEvent = destination;  // yea, the poller usage is a bit dumb
            EventPoller.PollState poll = eventPoller.poll(pollerHandler);
            if (poll == EventPoller.PollState.PROCESSING) {
                return tempPolledEvent;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}