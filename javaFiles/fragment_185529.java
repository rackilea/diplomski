package test;
    import java.util.Scanner;

    public class testclass {

        public static void main(String[] args) {
            //System.out.println("hi");
            Scanner in = new Scanner(System.in);
            int bob;
            int userChoice;
            String input;
            bob = (int) Math.floor(Math.random()*2);
            System.out.println(bob);

            System.out.println("Enter heads or tails?");
            input = in.nextLine(); // waits for user to press enter.
            System.out.println("You entered "+ input);

            if (bob == 0) {
                System.out.println("Computer flipped heads"); 
            }

            else {
                System.out.println("Computer flipped tails");
            }

            if(input.equals("Heads")) {
                userChoice = 0;
            }
            else {
                userChoice = 1;
            }

            if (userChoice == bob) {
                System.out.println("You win!");
            }
            else {
                System.out.println("Sorry you lost!");
            }

            in.close(); // IMPORTANT to prevent memory leaks
        }
    }