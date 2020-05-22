import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KDiffer {
    /** Solution for a dense array without duplicates. */
    static int solutionDenseArrayUnique(int[] a, int k) {
        // determine lower and upper bound of array elements
        int lower = Integer.MAX_VALUE;
        int upper = Integer.MIN_VALUE;
        for (int e : a) {
            lower = Math.min(lower, e);
            upper = Math.max(upper, e);
        }
        // create bitset of correct size
        int size = upper - lower + 1;
        BitSet collect = new BitSet(size);
        // fill bitset with array elements
        for (int e : a) {
            collect.set(e - lower);
        }
        // check for elements at distance k
        int result = 0;
        for (int e = collect.nextSetBit(0); e >= 0; e =
                collect.nextSetBit(e + 1)) {
            if (collect.get(e + k)) {
                result++;
            }
        }
        return result;
    }

    /** Solution for a dense array with duplicates. */
    static int solutionDenseArrayDuplicate(int[] a, int k) {
        // determine lower and upper bound of array elements
        int lower = Integer.MAX_VALUE;
        int upper = Integer.MIN_VALUE;
        for (int e : a) {
            lower = Math.min(lower, e);
            upper = Math.max(upper, e);
        }
        // create target of correct size
        int size = upper - lower + 1;
        int[] collect = new int[size];
        // fill target with array elements
        for (int e : a) {
            collect[e - lower]++;
        }
        // check for elements at distance k
        int result = 0;
        for (int e : a) {
            if (e - lower + k < size) {
                result += collect[e - lower + k];
            }
        }
        return result;
    }

    /** Solution for a sparse array without duplicates. */
    static int solutionSparseArrayUnique(int[] a, int k) {
        // collect array elements into a set
        Set<Integer> collect = new HashSet<>();
        for (int e : a) {
            collect.add(e);
        }
        // check for elements at distance k
        int result = 0;
        for (int e : collect) {
            if (collect.contains(e + k)) {
                result++;
            }
        }
        return result;
    }

    /** Solution for a sparse array with duplicates. */
    static int solutionSparseArrayDuplicate(int[] a, int k) {
        // collect array elements into a multiset
        Map<Integer, Integer> collect = new HashMap<>();
        for (int e : a) {
            Integer count = collect.get(e);
            collect.put(e, count == null ? 1 : count + 1);
        }
        // check for elements at distance k
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : collect.entrySet()) {
            Integer count = collect.get(entry.getKey() + k);
            if (count != null) {
                result += entry.getValue() * count;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = { 7, 5, 3, 4, 8, 10, 5, 7 };
        System.out.printf("Dense array, unique elements: %d%n",
                          solutionDenseArrayUnique(array, 2));
        System.out.printf("Sparse array, unique elements: %d%n",
                          solutionSparseArrayUnique(array, 2));
        System.out.printf("Dense array, duplicate elements: %d%n",
                          solutionDenseArrayDuplicate(array, 2));
        System.out.printf("Sparse array, duplicate elements: %d%n",
                          solutionSparseArrayDuplicate(array, 2));
    }
}