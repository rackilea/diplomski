import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestLIst {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        Map<String, List<String>> map = getMap(list);
        printMapAsLists(map);
    }

    public static Map<String, List<String>> getMap(List<String> list) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s: list) {
            if (!map.containsKey(s)) {
                List<String> mapList = new ArrayList<>();
                mapList.add(s);
                map.put(s, mapList);
            } else {
                ((List<String>)map.get(s)).add(s);
            }
        } 
        return map;
    }

    public static void printMapAsLists(Map<String, List<String>> map) {
        for (List<String> list : map.values()) {
            System.out.println(list);
        }
    }
}