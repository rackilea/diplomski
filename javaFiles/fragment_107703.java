import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        // Declaring the scanner
        Scanner scan = new Scanner(System.in);

        // Getting the number of integers to scan
        System.out.print("How many numbers: ");
        int n = scan.nextInt();

        // Declaring a numbers array
        int[] numbers = new int[n];

        // Scanning the integers
        for (int i = 0; i < n; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scan.nextInt();
        }

        // Determining if numbers are prime
        for (int i = 0; i < n; i++) {
            int j, upperRange = (int) Math.sqrt(numbers[i]);
            for (j = 2; j <= upperRange; j++)
                if (numbers[i] % j == 0)
                    break;
            if (numbers[i] != 1 && j > upperRange)
                System.out.println(numbers[i] + " is Prime");
            else
                System.out.println(numbers[i] + " is not Prime");
        }

    }
}