import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    /**
     * Holds information about a sub set
     *
     * @param <T> type of subset items
     */
    private static class SubSet<T> {
        List<T> items; // items of subset
        int startIndex1; // start index in list 1
        int endIndex1; // end index in list 1
        int startIndex2; // start index in list 2
        int endIndex2; // end index in list 2
    }

    /**
     * Run main example.
     *
     * @param args arguments - none honored.
     * @throws java.lang.Exception - in case of any error.
     */
    public static void main(String[] args) throws java.lang.Exception {
        // define 2 lists
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 3, 2, 5, 6, 7, 3, 8);
        List<Integer> list2 = Arrays.asList(2, 8, 7, 2, 3, 4, 5, 3, 2, 5, 1, 5);

        // print the lists
        System.out.println("First list: " + Arrays.toString(list1.toArray()));
        System.out.println("Second list: " + Arrays.toString(list2.toArray()));

        // get largest sub set
        SubSet<Integer> largest = getLargestSubSet(list1, list2);


        if (largest == null) {
            // nothing found
            System.out.println("No subset found.");
        } else {
            // print info about subset

            System.out.println("Largest subset: " + Arrays.toString(largest.items.toArray()));

            if (largest.startIndex1 > 0) {
                List<Integer> beforeList1 = list1.subList(0, largest.startIndex1);
                System.out.println("Items before largest subset in first list: "
                        + Arrays.toString(beforeList1.toArray()));
            }

            if (largest.endIndex1 < list1.size() - 1) {
                List<Integer> afterList1 = list1.subList(largest.endIndex1 + 1, list1.size());
                System.out.println("Items after largest subset in first list: "
                        + Arrays.toString(afterList1.toArray()));
            }

            if (largest.startIndex2 > 0) {
                List<Integer> beforeList2 = list2.subList(0, largest.startIndex2);
                System.out.println("Items before largest subset in second list: "
                        + Arrays.toString(beforeList2.toArray()));
            }

            if (largest.endIndex2 < list2.size() - 1) {
                List<Integer> afterList2 = list2.subList(largest.endIndex2 + 1, list2.size());
                System.out.println("Items after largest subset in second list: "
                        + Arrays.toString(afterList2.toArray()));
            }

        }


    }

    /**
     * Equality check for items.
     *
     * @param obj1 first item.
     * @param obj2 second item.
     * @param <T>  item type.
     * @return true if equal,false if not.
     */
    private static <T> boolean areEqual(T obj1, T obj2) {
        return obj1 == obj2; // naive comparison
    }

    /**
     * Get largest subset (first occurrence) for given lists.
     *
     * @param list1 first list.
     * @param list2 second list.
     * @param <T>   list item type.
     * @return Largest sub sequence list, or empty list.
     */
    private static <T> SubSet<T> getLargestSubSet(List<T> list1, List<T> list2) {
        SubSet<T> output = null;

        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {

                // optimisation : exit early
                if (output != null && output.items.size() > Math.min(list1.size(), list2.size())) {
                    return output;
                }

                if (areEqual(list1.get(i), list2.get(j))) {
                    // inspect sub sequence from this (i,j) onwards
                    output = inspectSubSet(list1, list2, i, j, output);
                }
            }
        }

        return output;
    }

    /**
     * For given starting indices, inspect if there is a larger subset, than given one.
     *
     * @param list1     first list.
     * @param list2     second list.
     * @param index1    first index.
     * @param index2    second index.
     * @param oldSubSet existing largest subset, for comparison.
     * @param <T>       list item type.
     * @return larger subset, if found, else existing one is returned as is.
     */
    private static <T> SubSet<T> inspectSubSet(List<T> list1, List<T> list2,
                                               int index1, int index2, SubSet<T> oldSubSet) {
        // new subset candidate
        SubSet<T> newSubSet = new SubSet<T>();
        newSubSet.items = new ArrayList<T>();
        newSubSet.startIndex1 = index1;
        newSubSet.endIndex1 = index1;
        newSubSet.startIndex2 = index2;
        newSubSet.endIndex2 = index2;

        // keep building subset as subsequent items keep matching
        do {
            newSubSet.items.add(list1.get(index1));
            newSubSet.endIndex1 = index1;
            newSubSet.endIndex2 = index2;
            index1++;
            index2++;
        } while (index1 < list1.size() && index2 < list2.size()
                && areEqual(list1.get(index1), list2.get(index2)));

        // return first, larger or same.
        if (oldSubSet == null) {
            return newSubSet;
        } else if (newSubSet.items.size() > oldSubSet.items.size()) {
            return newSubSet;
        } else {
            return oldSubSet;
        }
    }

}