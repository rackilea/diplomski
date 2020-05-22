import java.io.*;
import java.util.*;

public class NumberOfBarksTest {
    public static void main(String[] args) {
        int numOfDog = 0;
        int b[] = new int[10]; //1st bark
        int d[] = new int[10]; //time between barks
        int numberOfIntervals = 0;
        int x[] = new int[10]; //start of interval
        int y[] = new int[10]; //end of interval
        int barks[] = new int[10];
        int totalBarks = 0;
        Scanner q = new Scanner(System.in);

        for(int i = 0; i < 10; i++) {
            barks[i] = 0;
        }

        numOfDog = q.nextInt();

        for(int i = 0; i < numOfDog; i++) {
            b[i] = q.nextInt();
            d[i] = q.nextInt();
        }

        numberOfIntervals = q.nextInt();

        for(int i = 0; i < numberOfIntervals; i++) {
            x[i] = q.nextInt();
            y[i] = q.nextInt();
        }

        for(int dog = 0; dog < numOfDog; dog++) {
            for(int i = x[dog]; i <= y[dog]; i += d[dog]) {
                barks[dog]++;
            }
        }

        for(int i = 0; i < numOfDog; i++) {
            System.out.println("Barks for dog " + i + ": " + barks[i]);
            totalBarks += barks[i];
        }
        System.out.println("Total barks: " + totalBarks);
    }
}