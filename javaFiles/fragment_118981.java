package range;

import java.util.LinkedList;

public class RangeSet {

    private LinkedList<Range> linkedList;

    public RangeSet() {
        linkedList = new LinkedList<Range>();
    }

    public void add(Range range) {

        System.out.println("Adding " + range + " ...");

        if (linkedList.contains(range)) {
            return;
        }

        // First place the new range
        boolean done = false;
        for (int i = 0; i < linkedList.size() && !done; i++) {
            Range current = linkedList.get(i);
            if (range.min < current.min) {
                linkedList.add(i, range);
                done = true;
            }
        }
        if (!done) {
            linkedList.addLast(range);
        }

        // Now, do the necessary merges
        for (int i = 0; i < linkedList.size() - 1; i++) {
            Range current = linkedList.get(i);
            Range next = linkedList.get(i + 1);
            if (current.overlaps(next)) {
                current.extendBy(next);
                linkedList.remove(i + 1);
            }
        }

        System.out.println(this);
    }

    public void remove(Range remove) {

        System.out.println("Removing " + remove + " ...");

        for (int i = 0; i < linkedList.size(); i++) {

            Range current = linkedList.get(i);

            if (!current.overlaps(remove)) { // no overlap

                continue;

            } else if (remove.min <= current.min && remove.max >= current.max) { // the range to remove contains the current node

                linkedList.remove(i);

            } else if (remove.min < current.min) { // the range to remove intersects the current node from the left end

                current.min = remove.max;

            } else if (remove.max > current.max) { // [...] from the right end

                current.max = remove.min;

            } else { // the range to remove is contained within the current node, splitting it in two

                Range start = new Range(current.min, remove.min);

                Range end = new Range(remove.max, current.max);

                linkedList.remove(i);

                linkedList.add(i, start);

                linkedList.add(i + 1, end);
            }
        }

        System.out.println(this);
    }

    public String toString() {
        String s = "";
        for (Range r : linkedList) {
            s += r.toString() + " ";
        }
        return s;
    }

    public static void main(String[] args) {
        RangeSet set = new RangeSet();
        set.add(new Range(3, 6));
        set.add(new Range(1, 2));
        set.add(new Range(4, 10));
        set.add(new Range(50, 100));
        set.remove(new Range(9, 90));
        System.out.println("Final result:\n" + set);
    }
}