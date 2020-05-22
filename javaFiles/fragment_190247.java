import java.util.Scanner;

public class scratch {
    public static void main (String args[]) {
        // Get the count and allocate array.

        Scanner myinput = new Scanner (System.in);
        System.out.println ("Enter a number: ");
        int sayi = myinput.nextInt();

        int[] SayiDizisi = new int[sayi];

        // Get the values into the array.

        for (int i = 0; i < SayiDizisi.length ; i++) {
            System.out.println ("Enter the numbers: ");
            SayiDizisi[i] = myinput.nextInt();
        }

        // Output the maximum.

        int x = Max (SayiDizisi);
        System.out.println ("Maximum is: " + x);
    }

    public static int Max(int[] Array1) {
        // Assume first is largest.

        int max = Array1[0] ;

        // Check all others, finding larger.

        for (int i = 0; i < Array1.length ; i++) {
            if (Array1[i] > max)
                max = Array1[i];
        }

        // Return the largest found.

        return max;
    }
}