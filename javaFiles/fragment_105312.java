public class PeakChecker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] array = new int[]{1, 4, 2, 6, 4, 5, 10, 8, 7, 11};

        System.out.println(nPeaks(array, 2));
    }

    static int nPeaks(int[] array, int range) {

        // Check for special cases
        if (array == null) {
            return 0;
        }

        int result = 0, l, r;

        // Check main body
        for (int i = 0; i < array.length; i++) {
            boolean isPeak = true;
            // Check from left to right
            l = Math.max(0, i - range);
            r = Math.min(array.length - 1, i + range);
            for (int j = l; j <= r; j++) {
                // Skip if we are on current
                if (i == j) {
                    continue;
                }
                if (array[i] < array[j]) {
                    isPeak = false;
                    break;
                }
            }

            if (isPeak) {
                System.out.println("Peak at " + i + " = " + array[i]);
                result++;
                i += range;
            }
        }

        return result;
    }
}