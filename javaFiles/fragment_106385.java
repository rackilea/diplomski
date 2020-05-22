import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Collectionss {

    public static final int TO_ADD = 10000000;

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            long timeAL = timeAddToArrayList();
            long timeLL = timeAddsToLinkedList();
            System.out.printf("Time to add %,d Integer to ArrayList %.3f sec, LinkedList %.3f%n",
                    TO_ADD, timeAL / 1e9, timeLL / 1e9);
        }
    }

    private static long timeAddToArrayList() {
        long starttime = System.nanoTime();
        List<Integer> l1 = new ArrayList<Integer>();
        for (int i = 1; i <= TO_ADD; i++) {
            l1.add(i);
        }
        assert TO_ADD == l1.size();

        return System.nanoTime() - starttime;
    }

    private static long timeAddsToLinkedList() {
        long starttime = System.nanoTime();
        List<Integer> l2 = new LinkedList<Integer>();
        for (int i = 1; i <= TO_ADD; i++) {
            l2.add(i);
        }
        assert TO_ADD == l2.size();

        return System.nanoTime() - starttime;
    }
}