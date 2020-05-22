package range;

import java.util.LinkedList;

public class DistinctRangeList {

    private LinkedList<Range> linkedList;

    public DistinctRangeList() {
        linkedList = new LinkedList<Range>();
    }

    public void add(Range newRange) {
        for (int i = 0; i < linkedList.size(); i++) {
            Range range = linkedList.get(i);
            if (range.overlaps(newRange)) {
                return;
            } else if (newRange.min < range.min) {
                linkedList.add(i, newRange);
                return;
            } else {
                continue;
            }
        }
        linkedList.addLast(newRange);
    }

    public void remove(Range remove) {
        for (int i = 0; i < linkedList.size(); i++) {
            Range range = linkedList.get(i);
            if (range.equals(remove)) {
                linkedList.remove(range);   
            }
        }
    }

    public String toString() {
        String s = "";
        for (Range r : linkedList) {
            s += String.format("[%d, %d] ", r.min, r.max);
        }
        return s;
    }

    public static void main(String[] args) {
        DistinctRangeList lst = new DistinctRangeList();
        lst.add(new Range(3, 6)); // should add
        lst.add(new Range(3, 5)); // should not add
        lst.add(new Range(7, 8)); // should add
        lst.add(new Range(10, 15)); // should add
        lst.remove(new Range(10, 15)); 
        lst.add(new Range(10, 12)); // should add
        lst.add(new Range(1, 2)); // should add to the beginning
        System.out.println(lst);
    }
}