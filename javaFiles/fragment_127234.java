import java.util.Scanner;
public class Average {
    int tests;
    int total = 0;
    double average;
    public void Average1() {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter how many tests you will use. (Minimum 3, Maximum 10.) ");
        tests =  input.nextInt();
        for (int i = 1; i <= tests; ++i) {
            System.out.println("Enter the grade of for test " + i + ". (Do not include %)");
            total += input.nextInt();
        }

        average = total/tests; 
    }
}