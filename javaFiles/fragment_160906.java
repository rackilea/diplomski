import java.util.Scanner;

public class TemperatureLab {

    public TemperatureLab() {
    }

    public static void Temperaturelab(String[] args) {

        Scanner input = new Scanner(System.in);
        // Enter a temperature between -20 and 110 degrees fahrenheit.
        System.out.println("Enter temperature:");
        int temperature = input.nextInt();
        if (temperature >= 75) {
            System.out.println("You can go swimming");
        } else {
            System.out.println("Try again");
        }
        if (temperature > 60 || temperature <= 85) {
            System.out.println("You can play tennis");
        } else {
            System.out.println("Try again");
        }
        if (temperature < 10 || temperature <= 32) {
            System.out.println("You can go skiing");
        } else {
            System.out.println("Try again");
        }
        if (temperature <= 10) {
            System.out.println("You can play checkers");
        } else {
            System.out.println("Try again");
        }
        if (temperature < 32 || temperature <= 70) {
            System.out.println("You can play soccer");
        } else {
            System.out.println("Try again");
        }

        String answer;
        boolean yn;

        System.out.println("y/n");
        while (true) {
            answer = input.nextLine().trim().toLowerCase();
            if (answer.equals("y")) {
                yn = true;
                break;
            } else if (answer.equals("n")) {
                yn = false;
                break;
            } else {
                System.out
                        .println("Sorry, I didn't catch that. Please answer y/n");

            }
        }
    }
}