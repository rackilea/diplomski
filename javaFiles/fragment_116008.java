package test2;
import java.util.Scanner;

public class test2 {   
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter three sides, separated by spaces: ");
        double s1 = input.nextDouble();
        double s2 = input.nextDouble();
        double s3 = input.nextDouble();
        if (isValid(s1, s2, s3))
            System.out.println("Area is: " + area(s1, s2, s3));
        else
            System.out.println("Input is Invalid");
    }

    public static boolean isValid(double s1, double s2, double s3) {
         return ((s1 + s2 > s3) && (s1 + s3 > s2) && (s2 + s3 > s1));
    }

    public static double area(double s1, double s2, double s3) {
        double s = (s1 + s2 + s3) / 2;
        double theArea = Math.pow(s * (s - s1) * (s - s2) * (s - s3), 0.5);
        return theArea;
    } 
}