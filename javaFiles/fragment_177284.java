import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> map=new HashMap<String,String>();
        map.put("A", "Apple");
        map.put("A", "Anchor");
        System.out.println(map);
    }
}