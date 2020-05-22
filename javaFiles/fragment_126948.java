import java.util.Scanner;

public class SimpleChatBot {

    public static void main(String args[]) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("What is your name");
                String greeting = scanner.nextLine();
                System.out.print("Hi" + " " + greeting + ", ");

                System.out.print("How are you");
                String howareyou = scanner.nextLine();
                if (howareyou.equalsIgnoreCase("good")) {
                    System.out.print("Thats good to hear!");
                    break;
                } else if (howareyou.equalsIgnoreCase("not good")) {
                    System.out.print("Unfortunate");
                    break;
                }
            }
        }
    }
}