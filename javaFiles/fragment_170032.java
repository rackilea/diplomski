import java.util.Arrays;
import java.util.Scanner;

class T {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner sc = new Scanner(System.in);
        System.out.println("enter a number");
        int n = sc.nextInt();

        int s[] = new int[n];
        for (int i = 0; i < n; i++) {
            int e = sc.nextInt();
            s[i] = e;
        }

        Arrays.sort(s);
        // Even in ascending
        System.out.println("\nEven numbers in ascending order:");
        for (int j = 0; j < n; j++) {

            if (s[j] % 2 == 0) {
                System.out.print(s[j] + " ");
            }
        }

        // Odd in descending
        System.out.println("\nOdd numbers in descending order:");
        for(int j = (n -1); j >= 0; j--) {
            if (s[j] % 2 == 1) {
                System.out.print(s[j] + " ");
            }
        }
    }
}