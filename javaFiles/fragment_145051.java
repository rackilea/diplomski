import java.util.Scanner;

public class Requirement1 {

    public static void main(String[] args) {

        Scanner scan = new Scanner (System.in);
        String name, game, time, points;

        System.out.println("Please Enter Your Name");
        name = scan.nextLine();
        System.out.println("Players Name: " + name);

        for (int i = 0; i < 100; i++) {

            Scanner scan2 = new Scanner(System.in);
            System.out.println("Please Enter a Game Name (If You Are Done type \"quit\")");
            game = scan.nextLine();

            if (game.equals("quit")) {
                break;
            }
            System.out.println("Game: " + game);

            Scanner scan3 = new Scanner (System.in);
            System.out.println("Please Enter Your Score");
            points = scan.nextLine();
            System.out.println("Your Score: " + points);

            Scanner scan4= new Scanner (System.in);
            System.out.println("Please Enter the amount of time Spent Playing in Minutes");
            time = scan.nextLine();
            System.out.println("Time played: " + time);
        }
    }