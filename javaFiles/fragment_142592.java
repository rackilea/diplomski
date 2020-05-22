import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// based on http://www.cs.princeton.edu/introcs/43stack/RingBuffer.java.html
public class IntRingBuffer {
    private final int[] a;       // queue elements
    private int N = 0;           // number of elements on queue
    private int first = 0;       // index of first element of queue
    private int last  = 0;       // index of next available slot

    // cast needed since no generic array creation in Java
    public IntRingBuffer(int capacity) {
        a = new int[capacity];
    }

    public boolean isEmpty() { return N == 0; }
    public int size()        { return N;      }

    public void enqueue(int item) {
        if (N == a.length) { throw new RuntimeException("Ring buffer overflow"); }
        a[last] = item;
        last = (last + 1) % a.length;     // wrap-around
        N++;
    }

    // remove the least recently added item - doesn't check for underflow
    public int dequeue() {
        if (isEmpty()) { throw new RuntimeException("Ring buffer underflow"); }
        int item = a[first];
        N--;
        first = (first + 1) % a.length;   // wrap-around
        return item;
    }

    public static void main(String... args) {
        int size = 1000000;
        {
        long start = System.nanoTime();
        IntRingBuffer list = new IntRingBuffer(size);
        for(int i=0;i< size;i++)
            list.enqueue(i);
        for(int i=0;i< size;i++)
            list.dequeue();
        long time = System.nanoTime() - start;
        System.out.println(list.getClass().getSimpleName()+": Took "+time/1000/1000+" ms to add/remove "+size+" elements");
        }
        {
        long start = System.nanoTime();
        List<Integer> list = new LinkedList<Integer>();
        for(int i=0;i< size;i++)
            list.add(i);
        for(int i=0;i< size;i++)
            list.remove(0);
        long time = System.nanoTime() - start;
        System.out.println(list.getClass().getSimpleName()+": Took "+time/1000/1000+" ms to add/remove "+size+" elements");
        }
        {
        long start = System.nanoTime();
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i< size;i++)
            list.add(i);
        for(int i=0;i< size;i++)
            list.remove(0);
        long time = System.nanoTime() - start;
        System.out.println(list.getClass().getSimpleName()+": Took "+time/1000/1000+" ms to add/remove "+size+" elements");
        }

    }
}