import static java.lang.Math.*;
import java.util.Scanner;
import java.util.Arrays;
public class HelloWorld
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double [] numbers = {33.5, 67.5, 67.5, 88.0, 46.0, 94.5, 77.5, 83.0, 95.0, 80.5}; // declare, allocate memory, and store values

    double n = numbers.length; // get length of array
    Arrays.sort(numbers);
    System.out.println("The Array of Numbers are :");
    double sum = 0; //initiate and declare sum
    for (int i = 0; i < n; i++) {  //loop through n numbers
        System.out.println(numbers[i]);
        sum = sum + numbers[i];
    }      
    final double average = sum / n;
    System.out.println("The Sum of the Array is " + sum);
    System.out.println("The Average of the Array is " + average);

    double var1 = 0;
    double var2 = 0;
    double varSum = 0;
    for (int i = 0; i < n; i++) { 
        var1 = numbers[i] - average;            
        var2 = var1 * var1; // to square
        varSum = varSum + var2; // to get sum of all squared differences
    }
    double variance = varSum / n;
    System.out.printf("The Variance of the Array is  %.2f %n", variance); //%.2f rounds two decimal places 

    System.out.printf("The Standard Deviation is %.3f %n", Math.sqrt(variance));

    double middle = numbers.length / 2.0;
    double median = 0.0;
    int middleIndex = (int)middle;
    if (numbers.length % 2 == 1){
        median = numbers[middleIndex];
        System.out.println("The median is " + median);
    }
    else {
        median = (numbers[middleIndex-1] + numbers[middleIndex]) / 2;
        System.out.println("The median is " + median);
    }
}
}