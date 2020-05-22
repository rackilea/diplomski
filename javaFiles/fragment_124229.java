import com.google.common.collect.Collections2;

import java.util.*;

public class Test {
    private static void getSubsets(List<String> superSet, int idx, Set<String> current, List solution) {
        if (current.size() == 3) {
            solution.add(new HashSet<>(current));
            return;
        }
        if (idx == superSet.size()) {
            return;
        }
        String x = superSet.get(idx);
        current.add(x);
        getSubsets(superSet, idx + 1, current, solution);
        current.remove(x);
        getSubsets(superSet, idx + 1, current, solution);
    }

    public static List<Set<Integer>> getSubsets(List<String> superSet) {
        List res = new ArrayList<>();
        getSubsets(superSet, 0, new HashSet<>(), res);
        return res;
    }

    public static void main(String[] args) {
        List<String> initialSet = new ArrayList<String>() {{
            add("John");
            add("Peter");
            add("Dylan");
            add("Bryan");
            add("Pharell");
        }};
        List<Set<Integer>> subsets = getSubsets(initialSet);
        int counter = 1;
        for (Set s : subsets) {
            Collection<List<String>> results = Collections2.permutations(s);
            for (List<String> words : results) {
                System.out.println("Solution " + counter++);
                System.out.println("Job A: " + words.get(0));
                System.out.println("Job B: " + words.get(1));
                System.out.println("Job C: " + words.get(2));
                System.out.println();
            }
        }
    }
}