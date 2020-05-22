import java.util.*;

public class Test {

    static Map<Integer, Integer> groups = new HashMap<Integer, Integer>();

    public static void main(String... args) {
        groups.put(1, 2);
        groups.put(2, 3);
        groups.put(2, 4);
        groups.put(4, 5);
        System.out.println(searchFor(1, 5));
    }

    private static String searchFor(int from, int target) {

        // Target found?
        if (from == target) return "" + target;

        // Dead end?
        if (!groups.containsKey(from)) return null;

        // Recurse and try to find it from here.
        String path = searchFor(groups.get(from), target);
        return path == null ? null : from + " -> " + path;
    }
}