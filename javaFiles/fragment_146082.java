import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("Will there be 14 or perhaps 27 mails in my office today?");
        list.add("There are 40 candidates competing for 4 places");
        list.add("There are 6 teams each with 4 different channels");

        System.out.println("Numbers in each string:");
        list.stream().map(s -> Arrays.asList(s.replaceAll("[^-0-9]+", " ").trim().split(" ")))
                .collect(Collectors.toList()).stream()
                .map(lst -> lst.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList()))
                .forEach(System.out::println);

        System.out.println("Average of numbers in each string:");
        list.stream().map(s -> Arrays.asList(s.replaceAll("[^-0-9]+", " ").trim().split(" ")))
                .collect(Collectors.toList()).stream()
                .map(lst -> lst.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList()))
                .forEach(lst -> System.out.println(lst.stream().mapToInt(Integer::intValue).sum() / lst.size()));
    }
}