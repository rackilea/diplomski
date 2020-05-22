import java.util.Scanner;

public class Student {
    public String prompt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter some input:");
        return scanner.nextLine();
    }
}