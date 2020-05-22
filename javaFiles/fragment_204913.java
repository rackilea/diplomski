import java.util.ArrayDeque;
import java.util.Scanner;

public class SequenceQuestion {

    public static void constructSequence(int start, int seqLength) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        System.out.print(start);
        for (int i = 0; i < seqLength - 1; i++) {
            int print = 0;
            if (i % 3 == 0 && i != 0) queue.remove();

            if (i % 3 == 0) {
                print = queue.peek() + 1;
                queue.add(print);
            } else if (i % 3 == 1) {
                print = queue.peek() * 2 + 1;
                queue.add(print);
            } else if (i % 3 == 2) {
                print = queue.peek() + 2;
                queue.add(print);
            }
            System.out.print(", " + print);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        constructSequence(s.nextInt(), 50);
    }
}