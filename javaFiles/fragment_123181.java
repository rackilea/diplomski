import java.util.Scanner;
public class Program {

public static void main(String[] args) {

    String name = "Mike";
    Scanner scan = new Scanner(System.in);

    System.out.println("Enter your name: ");
    String user = scan.nextLine();

    while (!user.equals(name)) { 
        System.out.println("Enter your name: ");
        user = scan.nextLine();
    }
    System.out.println("Good bye");

 }
}