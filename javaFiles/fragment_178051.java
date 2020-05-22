import java.util.Scanner;

public class arraySorted {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int[] enterednumbers = new int[7];

        System.out.println("Enter 7 numbers in any order");
        for (int i = 0; i < enterednumbers.length; i++) {
            enterednumbers[i] = in.nextInt();

        }
        sort(enterednumbers);//Function Call

        for (int d = 0; d < enterednumbers.length; d++) {
            System.out.print(enterednumbers[d] + " ");
        }

    }

    public static void sort(int enterednumbers[]) {
        int n = 7;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (enterednumbers[i] > enterednumbers[j]) {
                    temp = enterednumbers[i];
                    enterednumbers[i] = enterednumbers[j];
                    enterednumbers[j] = temp;

                }
            }
        }
    }
}