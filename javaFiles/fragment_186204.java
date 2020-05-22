import java.util.Scanner;
public class BabyNim {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int pile1 = 10, pile2 = 10, pile3 = 10;

        do {
            System.out.printf("A: %d\tB: %d\tC: %d%n", pile1, pile2, pile3);
            System.out.print("Choose a pile: ");
            String pileChoice = in.next();
            System.out.printf("How many to remove from pile %s: ", pileChoice);
            int amount = in.nextInt();
            System.out.println();

            if (pileChoice.equals("A")) {
                pile1 -= amount;
            } else if (pileChoice.equals("B")) {
                pile2 -= amount;
            } else {
                pile3 -= amount;
            }
        } while (pile1 + pile2 + pile3 > 0);

        System.out.println("\nAll piles are empty. Good job!");
    }
}