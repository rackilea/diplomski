import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SwitchCase {

    public static Map<Integer, String> options = new LinkedHashMap<Integer, String>();
    static {
        options.put(1, "Add player");
        options.put(2, "Display transaction");
        options.put(3, "Begin the ride");
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        for (Integer option : options.keySet()) {
            System.out.println(option + ". " + options.get(option));
        }
        System.out.println("Enter your selection: ");
        int selection = sc.nextInt();
        switch (selection) {
        case 1:
        case 2:
        case 3:
            System.out.println("You have selected No." + selection);
            break;
        default:
            System.out.println("Please make a selection");
            break;
        }
        if (selection == 1) {
            int age = 0;
            System.out.print("Please enter your age : ");
            age = sc.nextInt();
            while (age < 100) {
                age += age;
            }
            System.out.println(age);
        } else if (selection == 2) {
            System.out.println(options.get(selection));
        } else if (selection == 3) {
            System.out.println(options.get(selection));
        } else {
            System.out.println("Please enter a valid input!");
        }
    }
}