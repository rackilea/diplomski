import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Play {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("100 : 200",
                "200 : 207",
                "200 : 203",
                "200 : 201",
                "300 : 202",
                "103 : 201",
                "103 : 202");
        List<String> processedList = list.stream().collect(Collectors.groupingBy(string -> string.split(":")[0].trim()))
                .values().stream().sorted((list1, list2) -> Integer.compare(list2.size(), list1.size()))
                .flatMap(List::stream).collect(Collectors.toList());

        System.out.println(processedList);
    }
}