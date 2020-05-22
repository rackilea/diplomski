import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String str = "Will there be 14 or perhaps 27 mails in my office today?";
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(str);
        List<Integer> list = new ArrayList<Integer>();
        while (m.find()) {
            list.add(Integer.parseInt(m.group()));
        }

        int sum = 0;
        for (int n : list) {
            sum += n;
        }
        System.out.println("Average: " + sum / list.size());

        // Using Stream
        OptionalDouble average = list.stream().mapToDouble(a -> a).average();
        System.out.println("Average: " + (int) average.getAsDouble());

        // Another way of doing it using Stream
        int sumInts = list.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Average: " + sumInts / list.size());
    }
}