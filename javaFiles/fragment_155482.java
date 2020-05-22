import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class MapSorter2 {

    public static void main(String[] args) {
        Map<Integer, List<String>> grouped = new HashMap<Integer, List<String>>();
        grouped.put(13, new ArrayList<String>() {{ add("Template 1"); add("Template 2"); }});
        grouped.put(24, new ArrayList<String>() {{ add("Something"); add("Something Else"); }});
        grouped.put(1, new ArrayList<String>() {{ add("Example"); add("Example"); add("Example"); }});
        grouped.put(35, new ArrayList<String>() {{ add("More Things"); }});

        Map<Integer, List<Integer>> sorted = new HashMap<Integer, List<Integer>>();
        sorted.put(13, new ArrayList<Integer>() {{ add(3); add(4); }});
        sorted.put(24, new ArrayList<Integer>() {{ add(1); add(2); }});
        sorted.put(1, new ArrayList<Integer>() {{ add(6); add(7); add(8); }});
        sorted.put(35, new ArrayList<Integer>() {{ add(5); }});

        Map<Integer, List<String>> sortedGrouped = sortMap(grouped, sorted);
        System.out.println(sortedGrouped);
    }

    private static Map<Integer, List<String>> sortMap(
            Map<Integer, List<String>> unsortedMap, Map<Integer, List<Integer>> sortOrder) {

        List<Entry<Integer, List<String>>> list = new LinkedList<Entry<Integer, List<String>>>(
                unsortedMap.entrySet());

        Collections.sort(list,
                new Comparator<Entry<Integer, List<String>>>() {

                    @Override
                    public int compare(Entry<Integer, List<String>> o1,
                            Entry<Integer, List<String>> o2) {
                        Integer key1 = o1.getKey();
                        Integer key2 = o2.getKey();
                        Integer sortObj1 = sortOrder.get(key1).get(0);
                        Integer sortObj2 = sortOrder.get(key2).get(0);
                        return sortObj1.compareTo(sortObj2);
                    }
                });

        Map<Integer, List<String>> sortedMap = new LinkedHashMap<Integer, List<String>>();
        for(Entry<Integer, List<String>> item : list){
            sortedMap.put(item.getKey(), item.getValue());
        }
        return sortedMap;
    }

}