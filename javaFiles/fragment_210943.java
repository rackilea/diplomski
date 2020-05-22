import java.util.*;


public class Test {

    public static Set<List<Integer>> solutions(List<TreeSet<Integer>> is, int n) {

        TreeSet<Integer> ts = is.get(0);
        Set<List<Integer>> sol = new HashSet<List<Integer>>();
        for (int i : ts.tailSet(n+1)) {
            if (is.size() == 1) {
                List<Integer> l = new ArrayList<Integer>();
                l.add(i);
                sol.add(l);
            } else 
                for (List<Integer> tail : solutions(is.subList(1, is.size()), i)) {
                    List<Integer> l = new ArrayList<Integer>();
                    l.add(i);
                    l.addAll(tail);
                    sol.add(l);
                }
        }
        return sol;
    }


    public static void main(String[] args) {
        String ss = "aaba";
        String s = "aa";

        List<TreeSet<Integer>> is = new ArrayList<TreeSet<Integer>>();

        // Compute all indecies of each character.
        for (int i = 0; i < s.length(); i++) {
            TreeSet<Integer> indecies = new TreeSet<Integer>();
            char c = s.charAt(i);
            for (int j = 0; j < ss.length(); j++) {
                if (ss.charAt(j) == c)
                    indecies.add(j);
            }
            is.add(indecies);
        }

        System.out.println(solutions(is, -1));
    }
}