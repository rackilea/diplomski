import java.util.Scanner;

public class Person {

    private final String name;

    public Person(String name) {
        this.name = name;
    }

    public static Person askName() {
        Scanner scanner = new Scanner(System.in);
        return new Person(scanner.nextLine());
    }
}