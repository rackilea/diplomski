import java.util.*;

public class Frequency {
    static void increment(Map<String,Integer> map, String key) {
        Integer count = map.get(key);
        map.put(key, (count == null ? 0 : count) + 1);
    }
    public static void main(String[] args) {
        String table[][] = new String[][] {
            {"127.0.0.9", "60", "75000","UDP", "Good"},
            {"127.0.0.8", "75", "75000","TCP", "Bad"},
            {"127.0.0.9", "75", "70000","UDP", "Good"},
            {"127.0.0.1", "", "70000","UDP", "Good"},
            {"127.0.0.1", "75", "75000","TCP", "Bad"}
        };
        final int M = table.length;
        final int N = table[0].length;
        List<Map<String,Integer>> maps = new ArrayList<Map<String,Integer>>();
        for (int i = 0; i < N; i++) {
            maps.add(new HashMap<String,Integer>());
        }
        for (String[] row : table) {
            for (int i = 0; i < N; i++) {               
                increment(maps.get(i), row[i]);
            }
        }
        for (Map<String,Integer> map : maps) {
            System.out.println(map);
        }
        System.out.println(maps.get(0).get("127.0.0.9"));
    }
}