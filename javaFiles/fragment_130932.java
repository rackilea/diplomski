import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static Comparable[] findCommon(Comparable[][] collections, Comparator comparator) {
        TreeSet<Comparable> set = new TreeSet<Comparable>(comparator);
        Collections.addAll(set, collections[0]);

        for (int i = 1; i < collections.length; i++)
            set.retainAll(Arrays.asList(collections[i]));

        return set.toArray(new Comparable[set.size()]);
    }

    public static void main(String[] args) {
        Comparable[] col_1 = {1, 1, 2};
        Comparable[] col_2 = {1, 1, 2, 3};
        Comparable[] col_3 = {1, 1, 2, 3, 4};

        Comparable[][] collections = {col_1, col_2, col_3};
        final int comparisonCount = 0;

        CountingComparator comparator = new CountingComparator();
        System.out.println(Arrays.toString(findCommon(collections, comparator)));
        System.out.println(comparator.getComparisonCount());
    }

    private static class CountingComparator implements Comparator<Comparable> {
        private int comparisonCount;

        public int getComparisonCount() {
            return comparisonCount;
        }

        @Override
        public int compare(Comparable o1, Comparable o2) {
            comparisonCount++;
            return o1.compareTo(o2);
        }
    }
}