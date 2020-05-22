import java.util.Scanner;

public class Troubleshoot {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char response = ' ';
        do {
            System.out.println("Stuff");
            System.out.print("Again? (y/n): ");
            response = s.next().charAt(0);
        } while (response == 'y');
    }

}