import java.util.Arrays;

public class Intersect {
    /**
     * Returns the intersection of two arrays.
     * 
     * @param arr1  First array.
     * @param arr2  Second array.
     * @return
     */
    public static int[] intersection(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) {
            return null;
        } else if (arr1.length == 0 || arr2.length == 0) {
            return new int[0];
        } else if (arr1.length > arr2.length) {
            return intersection(arr1, arr2, new int[arr2.length], 0, 0, 0);
        } else {
            return intersection(arr2, arr1, new int[arr1.length], 0, 0, 0);
        }
    }

    /**
     * Internal recursive function to generate intersecting array.
     * 
     * @param arrL   Longer array.
     * @param arrS   Shorter array.
     * @param arrI   Intersection array.
     * @param stepL  Longer array step.
     * @param stepS  Shorter array step.
     * @param stepI  Intersection array step.
     * @return
     */
    private static int[] intersection(int[] arrL, int[] arrS, int[] arrI, int stepL, int stepS, int stepI) {
        if (stepL > arrS.length) {
            return Arrays.copyOf(arrI, stepI);
        }

        int valL = arrL[stepL], valS = arrS[stepS];

        if (valL == valS) {
            arrI[stepI++] = valL;
        }

        stepS++;

        if (stepS > arrS.length - 1) {
            stepS = 0;
            stepL++;
        }

        return intersection(arrL, arrS, arrI, stepL, stepS, stepI);
    }

    public static void main(String[] args) {
        int[] a = { 1, 4, 4, 5, 8, 19, 23, 42, 73 };
        int[] b = { 1, 4, 5, 9, 17, 21, 42, 73 };

        Arrays.sort(a); // Ensure array 'a' is sorted first.
        Arrays.sort(b); // Ensure array 'b' is sorted first.

        int[] c = intersection(a, b);

        System.out.println(Arrays.toString(c)); // [1, 4, 4, 5, 42, 73]
    }
}