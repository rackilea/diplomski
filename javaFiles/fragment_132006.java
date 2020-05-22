import java.util.Arrays;

public class Queue {

    private int enqueueIndex;// Separate index to ensure enqueue happens at the end
    private int dequeueIndex;// Separate index to ensure dequeue happens at the
                            // start
    private int[] items;
    private int count;
    // Lazy to add javadocs please provide
    public Queue(int size) {
        enqueueIndex = 0;
        dequeueIndex = 0;
        items = new int[size];
    }
    // Lazy to add javadocs please provide
    public void enqueue(int newNumber) {
        if (count == items.length)
            throw new IllegalStateException();
        items[enqueueIndex] = newNumber;
        enqueueIndex = ++enqueueIndex == items.length ? 0 : enqueueIndex;
        ++count;
    }
    // Lazy to add javadocs please provide
    public int dequeue() {
        if (count == 0)
            throw new IllegalStateException();
        int item = items[dequeueIndex];
        items[dequeueIndex] = 0;
        dequeueIndex = ++dequeueIndex == items.length ? 0 : dequeueIndex;
        --count;
        return item;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}