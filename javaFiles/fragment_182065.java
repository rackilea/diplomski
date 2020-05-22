public class OrderManager {
    int nextSequence = 0;
    final SortedMap<Integer, byte[]> buffered = new TreeMap<>();
    final Consumer<byte[]> consumer;

    public OrderManager(Consumer<byte[]> consumer) {
        this.consumer = consumer;
    }

    public void accept(int num, byte[] bytes) {
        if (num == nextSequence) {
            consumer.accept(bytes);
            nextSequence++;
            while (buffered.firstKey() == nextSequence) {
                consumer.accept(buffered.remove(buffered.firstKey()));
                nextSequence++;
            }
        } else {
            buffered.put(num, bytes);
        }
    }
}