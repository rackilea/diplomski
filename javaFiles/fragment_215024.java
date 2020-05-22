import java.util.*;
import com.google.common.collect.*;

public class Test {
    public static void main(String[] args) {
        HashBiMap<String, HashSet<String>> bimap = HashBiMap.create();
        HashSet<String> set = new HashSet<>();
        bimap.put("foo", set);
        System.out.println(bimap.inverse().get(set)); // foo
        set.add("bar");
        System.out.println(bimap.inverse().get(set)); // null 
    }
}