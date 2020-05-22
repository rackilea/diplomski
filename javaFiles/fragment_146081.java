import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String str = "Will there be 14 or perhaps 27 mails in my office today?";
        String newStr = str.replaceAll("[^-0-9]+", " ");
        List<String> strList = Arrays.asList(newStr.trim().split(" "));
        List<Integer> list = strList.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());

        // One way
        OptionalDouble average = list.stream().mapToDouble(a -> a).average();
        System.out.println("Average: " + (int) average.getAsDouble());

        // Another way
        int sumInts = list.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Average: " + sumInts / list.size());
    }
}