import java.util.Scanner;

public class Test {
    public static void main(String... args) {
        String song;
        Scanner kdb = new Scanner(System.in);
        for (int amount = 5; amount > 0; amount--) {
            System.out.println("Enter song:");
            song = kdb.next();
            System.out.println("You chose " + song + ". Choose" + amount + " more");
        }
    }
}