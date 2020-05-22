import java.util.HashMap;
import java.util.Map;

public class StringToInt {

    private Map<String, Integer> map;

    private int counter = Integer.MIN_VALUE;

    public StringToInt() {
        map = new HashMap<String, Integer>();
    }

    public int toInt(String s) {
        Integer i = map.get(s);
        if (i == null) {
            map.put(s, counter);
            i = counter;
            ++counter;
        }
        return i;
    }
}