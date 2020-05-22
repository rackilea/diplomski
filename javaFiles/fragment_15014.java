import java.util.*;

public class Solution {
    public static char[] solve(char[] letters, char[][] rules) {
        // convert to adjacency list
        Map<Character, List<Character>> neighbours = new HashMap<>();
        for(char[] edge : rules) {
            char a = edge[0], b = edge[1];
            neighbours.computeIfAbsent(a, ArrayList::new).add(b);
            neighbours.computeIfAbsent(b, ArrayList::new).add(a);
        }

        // find nodes with 0 or 1 edges, in order
        List<Character> endpoints = new ArrayList<>();
        for(char a : letters) {
            if(!neighbours.containsKey(a) || neighbours.get(a).size() <= 1) {
                endpoints.add(a);
            }
        }
        Collections.sort(endpoints);

        // build output
        char[] out = new char[letters.length];
        Set<Character> used = new HashSet<>();
        int i = 0;
        for(char a : endpoints) {
            if(used.contains(a)) { continue; }
            out[i++] = a;
            used.add(a);
            // if it's a path, iterate along path
            while(neighbours.containsKey(a) && !neighbours.get(a).isEmpty()) {
                char b = neighbours.get(a).get(0);
                out[i++] = b;
                used.add(b);
                // remove previous neighbour so next one guaranteed at index 0
                neighbours.get(b).remove((Character) a); // don't convert to int
                a = b;
            }
        }
        return out;
    }
}