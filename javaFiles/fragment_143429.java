package cruft;

import java.io.PrintStream;

/**
 * ArraySwapDemo description here
 * @author Michael
 * @link
 * @since 12/3/12 9:48 PM
 */
public class ArraySwapDemo {

    public static void main(String[] args) {
        System.out.println(String.format("before: %s", arrayToString(args)));
        swapValues(args, 0, args.length-1);
        System.out.println(String.format("after : %s", arrayToString(args)));
    }

    // No checks for proper indexes, but you get the idea.
    private static void swapValues(String[] args, int i, int j) {
        String temp = args[i];
        args[i] = args[j];
        args[j] = temp;
    }

    public static String arrayToString(String [] array) {
        StringBuffer buffer = new StringBuffer(1024);
        buffer.append('{');
        for (int i = 0; i < array.length-1; ++i) {
           buffer.append(array[i]).append(',');
        }
        buffer.append(array[array.length-1]).append('}');
        return buffer.toString();
    }

}