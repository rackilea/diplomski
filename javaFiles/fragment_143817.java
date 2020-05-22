import java.util.Queue;
    import org.apache.commons.collections4.queue.CircularFifoQueue;`

    Queue<String> circularQueue = new CircularFifoQueue<String>(2);
    circularQueue.add("Bob");
    circularQueue.add("Doe");
    circularQueue.add("Joe");