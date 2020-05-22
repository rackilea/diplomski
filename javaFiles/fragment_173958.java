import java.util.Scanner;

public class Stones {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int stonesLeft = 13;
        int currentPick = 0;
        int currentPlayer = 2;

        System.out.println("In this game, two players alternate taking 1, 2 or 3 stones\n"
        + "from a pile of 13 stones until no stones are left.");
        System.out.println("The last person to pick up a stone is the winner!");

        while (stonesLeft != 0) {

            currentPlayer = currentPlayer%2 + 1;
            System.out.println("\nPlayer " + currentPlayer + ", how many stones do you wish to take?");
            currentPick = sc.nextInt();

            while (currentPick < 1 || currentPick > 3 || stonesLeft - currentPick < 0) {

                System.out.println("You have entered an invalid number!");
                System.out.println("Try again. How many stones do you wish to take? (1, 2, 3)");
                currentPick = sc.nextInt();

            }

            stonesLeft -= currentPick;
            System.out.println(stonesLeft + " stone(s) left!");

        }

        sc.close();

        System.out.println("Player " + currentPlayer + " won!");

    }

}