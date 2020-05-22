import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.Collections.emptySet;
import static java.util.stream.Collectors.toList;

public class Main {
    public static void powerset(int n) {
        System.out.println(
                powerset(IntStream.rangeClosed(1, n).boxed().collect(toList()))
        );
    }

    public static Set<Set<Integer>> powerset(List<Integer> set) {
        if (set.isEmpty()) {
            Set<Set<Integer>> result = new HashSet();
            result.add(emptySet());
            return result ;
        } else {
            Integer element = set.remove(0);
            Set<Set<Integer>> pSetN_1 = powerset(set);

            Set<Set<Integer>> pSet_N= new HashSet();
            pSet_N.addAll(pSetN_1);

            for (Set<Integer> s : pSetN_1) {
                Set<Integer> ss = new HashSet(s);
                ss.add(element);
                pSet_N.add(ss);
            }
            return pSet_N;
        }
    }

    public static void main(String[] args) throws Exception {
        powerset(3); // [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]
    }
}