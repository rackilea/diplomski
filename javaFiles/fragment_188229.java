import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.stream;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.joining;

public class Main {

    public static void main(String[] args) {
        Multimap<String, Object> myMultimap = newMultiMap();

        String[] keys = myMultimap.keySet().stream().sorted().toArray(String[]::new);
        List<?>[] values = stream(keys).map(myMultimap::get).toArray(List[]::new);
        int maxLength = stream(values).map(List::size).max(comparingInt(i -> i)).get();

        System.out.println(stream(keys).collect(joining("\t")));
        for (int line = 0; line < maxLength; line++) {
            for (List<?> value : values) {
                if (line < value.size()) {
                    System.out.print(value.get(line));
                } else {
                    System.out.print("\t");
                }
                System.out.print("\t");
            }
            System.out.println();
        }
    }

    private static Multimap<String, Object> newMultiMap() {
        Multimap<String, Object> myMultimap = ArrayListMultimap.create();

        myMultimap.put("id", 1517049512);
        myMultimap.put("id", 102888752);
        myMultimap.put("id", 102888762);
        myMultimap.put("id", 1558590692);
        myMultimap.put("id", 1516493341);
        myMultimap.put("id", 1555855832);
        myMultimap.put("id", 1557068421);
        myMultimap.put("id", 1557460861);
        myMultimap.put("id", 1570321872);
        myMultimap.put("id", 1582701092);

        myMultimap.put("suspended", false);
        myMultimap.put("suspended", false);
        myMultimap.put("suspended", false);
        myMultimap.put("suspended", false);
        myMultimap.put("suspended", false);
        myMultimap.put("suspended", false);
        myMultimap.put("suspended", false);
        myMultimap.put("suspended", false);

        myMultimap.put("verified", true);
        myMultimap.put("verified", true);
        myMultimap.put("verified", true);
        myMultimap.put("verified", true);
        myMultimap.put("verified", true);
        myMultimap.put("verified", true);
        myMultimap.put("verified", true);
        myMultimap.put("verified", true);

        return myMultimap;
    }

}