import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Task1 {
    public static void main(String... args) {
        List<String> userLines = Arrays.asList(new String[] { "1\tMozilla", "2\tMozilla", "3\tChrome" });
        List<String> appLines = Arrays
                .asList(new String[] { "1\t1\tHelloWorld", "2\t3\tSonar", "3\t1\tSonar", "4\t2\tHelloWorld", "5\t1\tHelloWorld" });

        Map<String, String> userMap = new HashMap<String, String>();
        Map<String, Map<String, Integer>> resultMap = new HashMap<String, Map<String, Integer>>();

        if (userLines != null) {
            for (int i = 0; i < userLines.size(); i++) {
                String[] userResultArray = userLines.get(i).split("\t"); // tab-separated
                userMap.put(userResultArray[0], userResultArray[1]);
            }
        } else {
            System.out.println("Error in reading line");
        }

        if (appLines != null) {
            for (int i = 0; i < appLines.size(); i++) {
                String[] appResultArray = appLines.get(i).split("\t"); // tab-separated
                if (userMap.containsKey(appResultArray[1])) {
                    String userName = userMap.get(appResultArray[1]);
                    if (resultMap.containsKey(userName)) {
                        Map<String, Integer> map = resultMap.get(userName);
                        Integer n = map.get(appResultArray[2]) == null ? 0 : map.get(appResultArray[2]);
                        map.put(appResultArray[2], ++n);
                    } else {
                        Map<String, Integer> map = new HashMap<String, Integer>();
                        map.put(appResultArray[2], 1);
                        resultMap.put(userName, map);
                    }
                }
            }
        } else {
            System.out.println("Error in reading line");
        }

        // sort
        Map<Integer, List<String>> sortedMap = new TreeMap<Integer, List<String>>();
        for (String userName : resultMap.keySet()) {
            for (String app : resultMap.get(userName).keySet()) {
                Integer n = resultMap.get(userName).get(app);
                List<String> list = sortedMap.get(n) == null ? new ArrayList<String>() : sortedMap.get(n);
                list.add(userName + "\t" + app);
                sortedMap.put(n, list);
            }
        }

        int limit = 0;

        outer:
        for (Integer n : sortedMap.keySet()) {
            for (String s : sortedMap.get(n)) {
                System.out.print(s);
                System.out.println("\t" + n);
                if (++limit == 2) break outer;
            }
        }
    }
}