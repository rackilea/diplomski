import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Example {

    public static void main(String[] args) {
        List<ArrayIndexAndSize> indexes = new ArrayList<ArrayIndexAndSize>();

        int[][] sWorld = {{1},{2,5,5,5,5},{3,6,6,6,6,6}};
        for (int i = 0; i < sWorld.length; i++){
            if (sWorld[i].length > 4) {
                 // add a pair (index, size) to the list
                 indexes.add(new ArrayIndexAndSize(i, sWorld[i].length));
            }
            //...
        }
        // then sort the list by array SIZE, in descending order
        Collections.sort(indexes);
        // Print it!
        System.out.println(indexes);
        /* output:
        "[[Array index: 2; Array size: 6], [Array index: 1; Array size: 5]]"
         */

        // Generating an array with the top ten indexes
        int[] topTenIndexes = new int[10];
        Arrays.fill(topTenIndexes, -1);
        for (int i = 0; i < indexes.size() && i < 10; i++) {
            topTenIndexes[i] = indexes.get(i).index;
        }
        // Print it
        System.out.println(Arrays.toString(topTenIndexes));
        /* output: [2, 1, -1, -1, -1, -1, -1, -1, -1, -1] */
    }

    public static class ArrayIndexAndSize implements Comparable<ArrayIndexAndSize> {
        public int index;
        public int size;
        public ArrayIndexAndSize(int index, int size) {
            this.index = index;
            this.size = size;
        }
        /* Order by size, DESC */
        /* This is called by Collections.sort and defines the order of two elements */
        public int compareTo(ArrayIndexAndSize another) {
            int thisVal = this.size;
            int anotherVal = another.size;
            return -(thisVal<anotherVal ? -1 : (thisVal==anotherVal ? 0 : 1));
       }
        @Override
        public String toString() {
            return "[Array index: "+index+"; Array size: "+size+"]"; 
        }
    }

}