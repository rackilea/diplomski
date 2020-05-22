import java.util.HashMap;
import java.util.Map;

public class Test {
    private static Map<String, Integer> count = new HashMap<String, Integer>();

    public static void main(String[] args) {
        addToCountMap("This is my test string and it contains Test and test and string and some more");
        addToCountMap("This is my test string and it contains Test and test and string and some more");
        addToCountMap("This is my test string and it contains Test and test and string and some more");
        addToCountMap("This is my test string and it contains Test and test and string and some more");
        addToCountMap("This is my test string and it contains Test and test and string and some more");

        mergeWithCountMap(count);

        System.out.println(count);
    }

    private static void addToCountMap(String test) {
        String[] split = test.split(" ");
        for (String string : split) {
            if (!count.containsKey(string)) {
                count.put(string, 0);
            }
            count.put(string, count.get(string) + 1);
        }
    }

    private static void mergeWithCountMap(Map<String, Integer> mapToMerge) {
        for (String string : mapToMerge.keySet()) {
            if (!count.containsKey(string)) {
                count.put(string, 0);
            }
            count.put(string, count.get(string) + mapToMerge.get(string));
        }
    }
}