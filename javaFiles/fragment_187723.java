import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(2, 3, 4, 5, 11, 6);
        Collections.sort(list);

        Integer sum = 0;
        Integer max = 13;

        for (int i=0; i<list.size(); i++) {
            sumNext(list, i, sum,max, new ArrayList<Integer>());
        }

    }

    private static void sumNext(List<Integer> list, int pos, Integer currentSum, Integer max,
            List<Integer> currentElement) {
        int nextSum = currentSum + list.get(pos);

        if (nextSum > max) {
            return;
        }

        currentElement.add(list.get(pos));
        if (nextSum == max) {
            for (Integer i : currentElement) {
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();
        } else if (nextSum < max && list.get(pos) < max - currentSum) {
            // as array is sorted if current element is higher than the diff
            // between currentSum and max there is no need to try with next
            // element
            for (int i=pos+1; i<list.size(); i++) {
                sumNext(list, i, nextSum, max, currentElement);
            }
        }
        currentElement.remove(list.get(pos));
    }

}