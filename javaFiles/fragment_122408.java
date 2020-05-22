import java.util.Scanner;

public class Lab7A_BRC {

    public static void main(String[] args) {
        System.out.println("\t\t Average arrays ");
        Scanner input = new Scanner(System.in);

        //array count varriable
        int n = 5;

        //array declaration
        int[] list1 = new int[n];
        double[] list2 = new double[n];

        System.out.print("Enter 5 integer values. ");
        for (int i = 0; i < n; i++) {
            list1[i] = input.nextInt();
        }

        if (!input.nextLine().equals("")) {
            throw new RuntimeException("Too many numbers entered!");
        }

            System.out.println("\t The average of the 5 integers is "
                    + average(list1, n));


        System.out.println("Enter 5 double values. ");
        for (int i = 0; i < n; i++) {
            list2[i] = input.nextDouble();

            if (i == (n - 1)) {
                System.out.println("\t The average of the 5 doubles is "
                        + average(list2, n));
            }

        }
    }

    public static int average(int[] array, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int holdNumber = array[i];
            sum += holdNumber;
        }

        int average = sum / n;
        return average;

    }

    public static double average(double[] array, int n) {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            double holdNumber = array[i];
            sum += holdNumber;
        }
        double average = sum / n;
        return average;
    }
}