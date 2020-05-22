package luckynumber;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random rand = new Random();
        int[] luckyArray = new int[6];

        // build array
        for (int i = 0; i < luckyArray.length; i++) {

            int luckyNumber = rand.nextInt(54) + 1;
            luckyArray[i] = luckyNumber;
        }
        // sort the array before detecting duplicates
        Arrays.sort(luckyArray);
        // detect duplicates in the array
        for (int i = 0; i < luckyArray.length; i++) {
            if (i > 0 && luckyArray[i] == luckyArray[i - 1]) {
                System.out.print("WE HAVE FOUND A DUPLICATE!");
                /* while (luckyArray[i - 1] == luckyArray[i]) { luckyArray[i] =
                 * rand.nextInt(54) + 1; } */
            }
        }
        for (int t = 0; t < luckyArray.length; t++) {

            if (t != 5) {
                System.out.print(luckyArray[t] + "-");
            } else
                System.out.print(luckyArray[t]);
        }
    }
}