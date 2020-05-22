@Component
public class JmsReceiver {

    private final Lock lock;
    private final Condition containsKey;
    private final Map<String, String> responses;

    public JmsReceiver() {
        this.lock = new ReentrantLock();
        this.containsKey = lock.newCondition();
        this.responses = new HashMap<>();
    }

    @JmsListener(destination = "QUEUE.FROM.MQ", containerFactory = "DefaultJmsListenerContainerFactory")
    public void receiveMessage(String message) {
        put(getKeyFromMessage(message), message);
    }

    public String get(String key) throws InterruptedException {
        lock.lock();
        try {
            while (!responses.containsKey(key)) {
                containsKey.await();
            }
            return responses.get(key);
        } finally {
            lock.unlock();
        }
    }

    public void put(String key, String messagee) {
        lock.lock();
        try {
            responses.put(key, messagee);
            containsKey.signalAll();
        } finally {
            lock.unlock();
        }
    }

}