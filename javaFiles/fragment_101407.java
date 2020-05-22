package week1;

/**
 * ThreeSum
 * @author mduffy
 * @since 8/14/12 1:53 PM
 * @link http://stackoverflow.com/questions/11950145/cant-correctly-setup-classpath#comment15924351_11950145
 */
public class ThreeSum {
    public static int count(int[] a) {
        // count triples that sum to 0
        int count = 0;
        for (int i = 0; i<a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                for (int k = j+1; k < a.length; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] values = new int[args.length];
        int valuesCount = 0;
        for (String arg : args) {
            int value = Integer.valueOf(arg);
            values[valuesCount++] = value;
        }
        System.out.println(String.format("count: %d", count(values)));
    }
}