import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MoveItemsToTop {
    public static void main(String[] args) {
        final List<String> items = Arrays.asList(new String[] { "one", "two", "three", "four", "five" });
        final List<String> thingsImLookingFor = Arrays.asList(new String[]{"two", "four"});

        Collections.sort(items, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (thingsImLookingFor.contains(o1)) {
                    return -1;
                }
                return 0;
            }
        });

        System.out.println(items);
    }
}