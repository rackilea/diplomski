/**
     * Class {@code BlockingQueueImpl} is the implementation of the Blocking Queue.
     * This class provides thread-safe operations
     * {@code public void offer(E element)} and {@code public E poll()}
     */

public class BlockingQueueImpl<E> implements BlockingQueue<E> {
    private volatile Queue<E> storage = new PriorityQueue<>();
    private volatile int capacity;
    private volatile int currentNumber;

    public BlockingQueueImpl(int capacity) {
        this.capacity = capacity;
        this.storage = new PriorityQueue<E>(capacity);
    }

    @Override
    public synchronized void offer(E element) {
        while (isFull()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage.add(element);
        currentNumber++;
        notifyAll();
    }

    @Override
    public synchronized E poll() {
        E polledElement;
        while (isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();
        polledElement = storage.poll();
        currentNumber--;
        return polledElement;
    }

    @Override
    public int size() {
        return capacity;
    }
    public synchronized boolean isFull(){
        return currentNumber >= capacity;
    }
    public synchronized boolean isEmpty(){
        return currentNumber == 0;
    }
}

public class Producer implements Runnable {
    BlockingQueue<String> source;
    String threadName;

    public Producer(BlockingQueue<String> source, String threadName) {
        this.source = source;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        while (!source.isFull()) {
            source.offer(Utilities.generateMessage(threadName));
        }
    }
}

public class Replacer implements Runnable {
    BlockingQueue<String> source;
    BlockingQueue<String> destination;
    String threadName;

    public Replacer(BlockingQueue<String> source,
                    BlockingQueue<String> destination,
                    String threadName) {

        this.source = source;
        this.destination = destination;
        this.threadName = threadName;
    }

    public synchronized void replace() {
        destination.offer(Utilities.transformMessage(threadName, source.poll()));
    }

    //Continue execution of a thread if a destination is not full and source is not empty.
    private boolean isRunning() {
        return (!destination.isFull()) && (!source.isEmpty());
    }

    @Override
    public void run() {
        while (isRunning()) {
            replace();
        }
    }
}
public class Utilities {

    public static final int NUMBER_OF_PRODUCER_THREADS = 3;
    public static final int NUMBER_OF_REPLACER_THREADS = 1000;
    public static final int NUMBER_OF_MESSAGES_TO_READ = 1000;
    public static final int STORAGE_CAPACITY = 100;

    public static String transformMessage(String threadName, String messageToTransform) {
        String[] splittedString = messageToTransform.split(" ");
        String newMessage = "Thread #" + threadName + " transferred message " + splittedString[splittedString.length - 1];
        return newMessage;
    }

    public static String generateMessage(String threadName) {
        return "Thread #" + threadName + " generated message #" + threadName;
    }

    public static void spawnDaemonThreads(String threadName,
                                          int numberOfThreadsToSpawn,
                                          BlockingQueue<String> source,
                                          BlockingQueue<String> destination) {

        if (destination == null) {
            for (int i = 1; i < numberOfThreadsToSpawn + 1; i++) {
                String name = threadName + i;
                Producer producer = new Producer(source, name);

                Thread threadProducer = new Thread(producer);
                threadProducer.setName(name);
                threadProducer.setDaemon(true);
                threadProducer.start();
            }
        } else {
            for (int i = 1; i < numberOfThreadsToSpawn + 1; i++) {
                String name = threadName + i;
                Replacer replacer = new Replacer(source, destination, name);

                Thread threadProducer = new Thread(replacer);
                threadProducer.setName(name);
                threadProducer.setDaemon(true);
                threadProducer.start();
            }
        }
    }
}