import static java.lang.System.out;
import java.util.*;

class Main {
    public static void main(String args[]) {
        int arr[] = new int[99];
        Scanner scan = new Scanner(System.in);

        out.print("Enter total number of integers you would like to sort: ");
        int n = scan.nextInt();

        while (n < 1 || n > 99) {
            out.print("Please enter a number between 1 and 99: ");
            n = scan.nextInt();
        }

        for (int i = 0; i < n; i++) {
            out.print("Input a number less than 100: ");
            arr[i] = scan.nextInt();

            if (arr[i] > 100) { 
                out.println("That number was over 100. Try again.");
                i--; 
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (Math.abs(arr[j]) > Math.abs(arr[j + 1])) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        out.println("Sorted List :");

        for (int i = 0; i < n; i++) {
            out.print(arr[i] + "  ");
        }
    }
}