package latest;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public class Latest {

private static int[] randomInteger;

public static void main(String[] args) {
    int indexPosition = 0;
    Scanner input = new Scanner(System.in);
    randomInteger = new int[100];
    Random rand = new Random();
    for (int i = 0; i < randomInteger.length; i++)

        randomInteger[i] = rand.nextInt();

    System.out
            .println("Hello, please enter an integer for the array index position: ");
    do {
        try {
            // get array index position
            indexPosition = input.nextInt();
        } catch (InputMismatchException e) {
            System.out
                    .println("You did not input a valid value. Please enter an Integer value between 0 and 100");
            input.nextLine();
            continue;
        } catch (Exception e) {
            System.out
                    .println("You did not input a valid value. Please enter an Integer value between 0 and 100");
            input.nextLine();
            continue;
        }
        if (indexPosition < 0 || indexPosition > 100) {
            System.out
                    .println("You did not input a valid value. Please enter an Integer value between 0 and 100");
        }

    } while (indexPosition < 0 || indexPosition > 100);
    System.out.println(randomInteger[indexPosition]);
    input.close();
}
}