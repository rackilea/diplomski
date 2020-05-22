import java.util.*;
import java.util.stream.*;

public class Test {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("abC", "Long Mixed", "SHORT");
        List<String> list2 = list
            .stream()
            .map(str -> str.length() > 5 ? str.toUpperCase() : str.toLowerCase())
            .collect(Collectors.toList());
        for (String result : list2) {
            System.out.println(result); // abc, LONG MIXED, short
        }
    }
}