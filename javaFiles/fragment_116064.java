/**
 * Find maximum sum of elements in the input array, with at most n adjacent
 * elements included in the sum.
 */
public static int maxSum (int input[], int n) {
    int sums[] = new int[n+1];  // new int[] fills the array with zeros
    int max = 0;

    for (int x: input) {
        int newMax = max;
        // update sums[k] for k > 0 by adding x to the old sums[k-1]
        // (loop from top down to avoid overwriting sums[k-1] too soon)
        for (int k = n; k > 0; k--) {
            sums[k] = sums[k-1] + x;
            if (sums[k] > newMax) newMax = sums[k];
        }
        sums[0] = max;  // update sums[0] to best sum possible if x is excluded
        max = newMax;   // update maximum sum possible so far
    }
    return max;
}