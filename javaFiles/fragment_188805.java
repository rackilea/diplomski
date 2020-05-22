import com.google.common.collect.HashMultiset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SO {

    public static void main(String args[]) {
        Map<String, Object> map = new HashMap<>();
        map.put("foo", "FOO");
        map.put("bar", "BAR");

        HashMultiset<Map<String, Object>> n1Properties = HashMultiset.create();
        n1Properties.addAll(Collections.singleton(map));

        System.out.println(n1Properties);
    }

}