import java.util.Random;

public class testprog {
    private int[] pool;           // The pool of numbers.
    private int size;             // The current "size".
    private Random rnd;           // A random number generator.

    // Constructor: just initilise the pool.

    public testprog (int sz) {
        pool = new int[sz];
        size = sz;
        rnd = new Random();
        for (int i = 0; i < size; i++) pool[i] = i;
    }

    // Get next random number in pool (or -1 if exhausted).

    public int next() {
        if (size < 1) return -1;
        int idx = rnd.nextInt(size--);
        int rval = pool[idx];
        pool[idx] = pool[size];
        return rval;
    }

    // Test program for the pool.

    public static void main(String[] args) {
        testprog tp = new testprog (10);
        for (int i = 0; i < 11; i++) System.out.println (tp.next());
    }
}