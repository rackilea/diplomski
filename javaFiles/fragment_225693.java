import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Example {

    public static void main( String[] args ) {
        List<Integer> list1 = Arrays.asList(1, 0);
        List<Integer> list2 = Arrays.asList(0, 1);
        List<Integer> list3 = Arrays.asList(3, 2);
        List<Integer> list4 = Arrays.asList(2, 3);

        List<List<Integer>> lists = Arrays.asList(list1, list2, list3, list4);

        System.out.println(getUnduplicateList(lists));
    }

    public static List<List<Integer>> getUnduplicateList(List<List<Integer>> lists) {
        return lists
                .stream()
                .map(HashSet::new)
                .distinct()
                .map(ArrayList::new)
                .collect(Collectors.toList());
    }
}