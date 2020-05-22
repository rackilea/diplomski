import java.util.*;
public class App {
    public static void main(String[] args) {
        int numweek = 0;
        double valkms = 0;
        double vallits = 0;
        double average = 0;
        double result = 0;
        int count = 0;
        double sum = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of week: ");
        numweek = sc.nextInt();
        while (numweek < 1) {
            System.out.println("Enter a positive of number week: ");
            numweek = sc.nextInt();
        }
        while (count < numweek) {
             count++;
             System.out.print("Enter value of litres: : ");
             vallits = sc.nextDouble();
             while (vallits < 0) {
                 System.out.print("Positive litres: ");
                 vallits= sc.nextDouble();
             }
             System.out.print("Enter value of kilometres: : ");
             valkms = sc.nextDouble();
             while (valkms < 0) {
                 System.out.print("Positive kilometres: ");
                 valkms = sc.nextDouble();
             }
             if (vallits == 0 || valkms == 0) {
                 break;
             }
             result = vallits / valkms; 
             sum += result;
             System.out.println(result); 
        }       
        System.out.print("Average of fuel economy is: " + getAverg(sum, numweek));
    }

    public static double getAverg(double sum, double numOfWeeks) {
        double average;
        average = sum/numOfWeeks;
        return average;
    }
}