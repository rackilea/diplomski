import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SOPlayground {

    public static void main(String[] args) throws Exception {
        Integer numbers[] = new Integer[]{1, 3, 4, 6, 7, 9, 0, 9, 8, 6, 5, 4, 3, 2, 1};

        List<Integer> a = Arrays.asList(numbers);
        Set<Integer> s = new HashSet(a);
        for (Integer i : s) {
            if (Collections.frequency(a, i) > 1) {
                System.out.println(i + " is a duplicate");
            }
        }
    }
}