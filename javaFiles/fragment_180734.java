import java.util.Deque;
import java.util.LinkedList;

public class Example {

    private LinkedList<Comparable> merge(final Deque<Comparable> left, final Deque<Comparable> right) {
        final LinkedList<Comparable> merged = new LinkedList<>();
        while (!left.isEmpty() && !right.isEmpty()) {
            if (left.peek().compareTo(right.peek()) <= 0) {
                merged.add(left.pop());
            } else {
                merged.add(right.pop());
            }
        }
        merged.addAll(left);
        merged.addAll(right);
        return merged;
    }

    public void mergeSort(final LinkedList<Comparable> input) {
        if (input.size() != 1) {
            final LinkedList<Comparable> left = new LinkedList<Comparable>();
            final LinkedList<Comparable> right = new LinkedList<Comparable>();
            // boolean used to decide if we put elements
            // in left or right LinkedList
            boolean logicalSwitch = true;
            while (!input.isEmpty()) {
                if (logicalSwitch) {
                    left.add(input.pop());
                } else {
                    right.add(input.pop());
                }
                logicalSwitch = !logicalSwitch;
            }
            mergeSort(left);
            mergeSort(right);
            input.addAll(merge(left, right));
        }
    }
}