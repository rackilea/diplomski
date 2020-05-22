import java.util.Scanner;

public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // Read in T.
        int T = sc.nextInt();

        int[] myNumbers = new int[T];

        // Read in all input, and calculate the number of digit divisors.
        for (int i = 0; i < T; i++){
            int n = sc.nextInt()
            myNumbers[i] = findDivisor(n);
        }

        // For each input, print out the number of digit divisors.
        System.out.println("Number of digit divisors:");
        for (int i = 0; i < T; i++){
            System.out.println(myNumbers[i]);
        }
}