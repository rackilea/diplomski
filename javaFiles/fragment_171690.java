import java.util.Scanner;

public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // Read in T.
        int T = sc.nextInt();

        // Read in T integers, for each print the number of digit divisors.
        for (int i = 0; i < T; i++){
            int n = sc.nextInt()
            System.out.println(findDivisor(n));
        }
}