import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("^(?!000|666|9\\d{2})\\d{3}-\\d{2}-\\d{4}$");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Next number :");
            Matcher matcher = pattern.matcher(sc.nextLine());
            if (matcher.find()) {
                System.out.println("Matches");
            } else {
                System.out.println("Doesn't match");
            }
        }
    }
}