import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    public static void main(String... args) throws Exception {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt(); // no. of rows
        int b = input.nextInt(); // no. of columns
        Pattern pattern = Pattern.compile("#(--+)#");
        int count = 0;
        for (int i = 0; i < a; i++) {
            String temp = input.next().trim();
            if (temp.length() > b) {
                temp.substring(0, b);
            }
            Matcher matcher = pattern.matcher(temp);
            if (matcher.find()) {
                count++;
            }
        }
        System.out.println(count);
    }
}