import java.util.Scanner;

public class Person {

    private final String name;

    public Person() {
        name = askName();
    }

    public static String askName() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}