import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Sequences {
    public static void main(String [] args) {
        int[] arr = {2, 9, 0, 6, 1, 2, 3, 6, 6, 1, 0, 1, 2, 3, 5, 4, 0, 3, 7, 1, 2, 3, 7, 5, 0};
        int sequenceLength = 3;

        Map<String, Integer> map = new HashMap<String, Integer>();
        int count;
        String str1, str2;

        for (int i = 0; i <= arr.length - sequenceLength; i++) {
            str1 = "";
            count = 0;
            for (int a = i; a < i + sequenceLength; a++) {
                    str1 += "" + arr[a];
                }
            if (map.get(str1) != null) {
                continue;
            } else {
                map.put(str1, count);
            }
            for (int ii = i; ii <= arr.length - sequenceLength; ii++) {
                str2 = "";
                for (int a = ii; a < ii + sequenceLength; a++) {
                    str2 += "" + arr[a];
                }
                if (str1.equals(str2)) {
                    count++;
                    map.put(str1, count);
                }
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()){ 
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }

    }
}