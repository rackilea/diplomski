package sales;

import java.util.Scanner;

import utils.Utils;

public class Person {
    public static void main(String[] args) {
        // Initialise scanner
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter your annual sales:");

        // Read sales from input & calculate salary
        double annualSales = input.nextDouble();
        double salary = Utils.calculateSalary(annualSales);

        // Calculate commission bonus
        double commissionBonus = 1.5 * annualSales;

        // Print information for user
        System.out.println("The total yearly salary is: " + Utils.numFormat(salary));
        System.out.println("Total Sales \t\t Total Compensation");

        while (annualSales <= commissionBonus) {
            System.out.println(annualSales + " \t\t " + salary);
            annualSales += 5000;

            // Update salary according to annual sales
            salary = Utils.calculateSalary(annualSales);
        }

        // Close scanner
        input.close();
    }
}