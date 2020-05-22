import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        Scanner stdin = new Scanner(System.in);

        do {
            System.out.println("Enter: ");
            String strin = stdin.next();
            if (isNumeric(strin)) {
                System.out.println("Please enter a non numeric value");
            } else {
                list.add(strin);
            }

            Collections.sort(list);
            System.out.println("Current list is " + list);
            System.out.println("Add more? (y/n)");

        } while (stdin.next().startsWith("y"));

        System.out.println("List is " + list);
        String[] arr = list.toArray(new String[0]);
        System.out.println("Array is " + Arrays.toString(arr));
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}