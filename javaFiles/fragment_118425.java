import java.util.HashMap;
import java.util.Map;

public class Test {

    public static String item;
    public static String brand;

    static Map<String, String> myMap = newMap();

    public static void main(String[] args) {

        Add("apple");

    }

    public static HashMap<String, String> newMap() {
        return new HashMap<>();
    }

    public static void Add(String item) {
        String brand = "nobrand";
        myMap.put(item, brand);
    }

}