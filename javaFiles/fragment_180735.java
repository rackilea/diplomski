import java.util.ArrayList;
import java.util.List;

public class Example {

    private List<Comparable> merge(final List<Comparable> left, final List<Comparable> right) {
        final List<Comparable> merged = new ArrayList<>();
        while (!left.isEmpty() && !right.isEmpty()) {
            if (left.get(0).compareTo(right.get(0)) <= 0) {
                merged.add(left.remove(0));
            } else {
                merged.add(right.remove(0));
            }
        }
        merged.addAll(left);
        merged.addAll(right);
        return merged;
    }

    public void mergeSort(final List<Comparable> input) {
        if (input.size() != 1) {
            final List<Comparable> left = new ArrayList<Comparable>();
            final List<Comparable> right = new ArrayList<Comparable>();
            boolean logicalSwitch = true;
            while (!input.isEmpty()) {
                if (logicalSwitch) {
                    left.add(input.remove(0));
                } else {
                    right.add(input.remove(0));
                }
                logicalSwitch = !logicalSwitch;
            }
            mergeSort(left);
            mergeSort(right);
            input.addAll(merge(left, right));
        }
    }
}