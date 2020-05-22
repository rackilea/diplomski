import java.util.*;

public class MyClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome Valued player, take your guess!: ");

        int min = 0;
        int max = 100;
        int input;
        int c = 21;
        int count = 0;
        int userscore = 0;
        int dealerscore = 0;
        int gamesplayed = 0;

        Random rand = new Random();
        int r = rand.nextInt(max - min) + min;
        input = sc.nextInt();

        /*
        This loop runs the game until the user enters 21
        */
        while (input != c) {
            System.out.println("Computer's number:" + r);

            if (Math.abs(input - c) <= Math.abs(r - c)) {
                System.out.println("The winner is the user! " + input);
                userscore++; //You mixed up userscore and dealerscore
            } else {
                System.out.println("The winner is the computer! " + r);
                dealerscore++; //You mixed up userscore and dealerscore
            }

            /*
            User needs to keep entering guesses
            */
            System.out.println();
            System.out.println("Enter another guess: ");
            r = rand.nextInt(max - min) + min;
            input = sc.nextInt();
        }

        /*
        You don't need any conditions since the games have already ended
        But it should be outside and after the loop
        */
        System.out.println("Number of hands played:" + gamesplayed);
        System.out.println("Dealer won:" + dealerscore);
        System.out.println("User won:" + userscore);
    }
}