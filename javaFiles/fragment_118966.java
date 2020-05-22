import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;

public class QuickestRoute {
    static int totalWeight = 0;

    public static String outpit;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String input1[] = { "1-2-30#2-3-25#3-4-30#4-5-45#5-6-30#6-7-15#7-8-60#8-9-40",
                "10-11-45#11-4-60#4-12-60#12-13-45#13-14-30#14-15-35",
                "1-3-40#3-4-25#4-16-30#16-17-15#17-18-20#18-19-30#19-20-25", "21-12-30#12-17-180#17-22-45" };

        String input2 = "12#18";
        String[] output = quickestMetroRoute(input1, input2);
        /*
         * for(int i=0;i<output.length;i++) System.out.println(output[i]);
         */
    }

    public static String[] quickestMetroRoute(String[] input1, String input2) {
        // Write code here
        Map<String, Integer> input = new HashMap<String, Integer>();
        for (int i = 0; i < input1.length; i++) {
            StringTokenizer str = new StringTokenizer(input1[i], "#");
            while (str.hasMoreTokens()) {
                String[] parts = str.nextToken().split("-");
                String node = parts[0] + "-" + parts[1];
                int weight = Integer.parseInt(parts[2]);
                input.put(node, weight);
            }
        }
        Map<String, Integer> sortedMap = sortByValue(input);
        System.out.println(Collections.singletonList(sortedMap));
        String[] parts = input2.split("#");
        String source = parts[0];
        String destination = parts[1];
        searchMapKey(source, destination, sortedMap);
        /*
         * for (Map.Entry<String, Integer> entry : input.entrySet()) { String
         * key = entry.getKey(); Integer value = entry.getValue(); // ... }
         */
        System.out.println("outpit: " + outpit);
        System.out.println("totalWeight: " + totalWeight);

        return input1;
    }

    private static void searchMapKey(String source, String destination, Map<String, Integer> input) {
        // TODO Auto-generated method stub

        ArrayList<Map<String, Integer>> removeList = new ArrayList<Map<String, Integer>>();
        for (Iterator<Entry<String, Integer>> it = input.entrySet().iterator(); it.hasNext();) {
            Entry<String, Integer> entry = it.next();
            String key = entry.getKey();
            Integer value = entry.getValue();
            // ...
            String[] nodeParts = key.split("-");
            String nodeFirst = nodeParts[0];
            String nodeSecond = nodeParts[1];

            if (nodeFirst.equals(source)) {
                totalWeight += value;
                outpit += key;
                if (destination.equals(nodeSecond)) {
                    totalWeight += value;
                    outpit += key;
                    return;
                } else {
                    it.remove();
                    // input.remove(key);
                    Map<String, Integer> next = new HashMap<String, Integer>();
                    next.putAll(input);
                    searchMapKey(nodeSecond, destination, next);
                }
            }
            if (nodeSecond.equals(source)) {
                totalWeight += value;
                outpit += key;
                if (destination.equals(nodeFirst)) {
                    totalWeight += value;
                    outpit += key;
                    return;
                } else {
                    it.remove();
                    // input.remove(key);
                    Map<String, Integer> next = new HashMap<String, Integer>();
                    next.putAll(input);
                    searchMapKey(nodeFirst, destination, next);
                }
            }
        }

    }

    private static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap) {

        // 1. Convert Map to List of Map
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

        // 2. Sort list with Collections.sort(), provide a custom Comparator
        // Try switch the o1 o2 position for a different order
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // 3. Loop the sorted list and put it into a new insertion order Map
        // LinkedHashMap
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        /*
         * //classic iterator example for (Iterator<Map.Entry<String, Integer>>
         * it = list.iterator(); it.hasNext(); ) { Map.Entry<String, Integer>
         * entry = it.next(); sortedMap.put(entry.getKey(), entry.getValue()); }
         */

        return sortedMap;
    }

}