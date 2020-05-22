package test;

import java.util.Scanner;
import java.text.DecimalFormat;

public class test {
    public static void main(String[] args) {

        // First input group
        int employeeType;               // 1-4 (Manager, Hourly, Commissioned, Pieceworker)
        int compSize;                   // Company size (4 - 10)
        int hoursWrkd;                  // Whole Number, no partial hours.
        String employeeName;            // Name of the Employee

        // Pay for each worker type
        double rateManagerWrkr = 800.00;// Fixed weekly salary
        double managerBonus = 750.00;   // $750.00 bonus for manager
        double rateHourWrkr;            // Hourly + overtime > 40 = 1.5 time hourly rate
        double hourOvertime = 1.5;      // If hoursWrkd > 40
        double hourOvertimeStore;       // Stores value
        double rateCommWrkr = 650.00;   // Fixed weekly salary
        double commBonus = 250.00;      // $250.00 bonus for commissioned worker

        double commWklySal;             // 5.7% time weekly salary (650.00 * 5.7)

        double ratePieceWrkr = 400.00;  // Fixed weekly salary

        // Deductions
        double medicalDues = 20.00;     // $20.00 per pay period
        double fedTax = 0.30;           // 30% of gross
        double socialSec = 0.05;        // 5% of gross
        double deductDues;
        double fedTaxFinal;
        double socialSecFinal;

        // Totals
        double managerGross;
        double managerNet;
        double hourGross;
        double hourNet;
        double commGross;
        double commNet;
        double pieceGross;
        double pieceNet;

        // Convert decimals to match ####.## place ($9999.99)
        DecimalFormat df = new DecimalFormat("####.##");

        String employeeTitle;
        int numberOfEmployees=0;

        Scanner input = new Scanner(System.in);


        System.out.print("Enter the number of Employees in your company ");
        numberOfEmployees = input.nextInt();


        for(int i=0;i<numberOfEmployees;i++)
        {
            System.out.println("----------------------------------------------");
            System.out.println("Enter Information for Employee Number " + Integer.toString(i+1));
            System.out.print("Enter an employee paycode (1-4): ");
            employeeType = input.nextInt();

            switch (employeeType)
            {
            case 1:
            {
                employeeTitle = "Manager";
                System.out.println("You selected manager!");
                System.out.print("What's your name? :");
                employeeName = input.next();

                System.out.print("Enter the amount of hours worked this week: ");
                hoursWrkd = input.nextInt();

                System.out.println("Name: "             + employeeName);
                System.out.println("Title: "            + employeeTitle);
                System.out.println("Type: "             + employeeType);
                System.out.println("Hours worked: "     + hoursWrkd);

                managerGross = rateManagerWrkr + managerBonus;
                System.out.println("Gross pay: $"        + df.format(managerGross));
                System.out.println("Federal Tax: $"      + df.format(managerGross * fedTax));
                System.out.println("Social Security: $"  + df.format(managerGross * socialSec));
                System.out.println("Medical: $"          + df.format(medicalDues));

                fedTaxFinal = managerGross * fedTax;
                socialSecFinal = managerGross * socialSec;
                deductDues = (fedTaxFinal + socialSecFinal + medicalDues);
                managerNet = (managerGross - deductDues);
                System.out.println("Net pay: $"          + df.format(managerNet));
            }
            break;
            case 2:
            {
                employeeTitle = "Hourly";
                System.out.println("You selected hourly!");
                System.out.print("What's your name? :");
                employeeName = input.next();

                System.out.print("Enter the amount of hours worked this week: ");
                hoursWrkd = input.nextInt();
                System.out.print("Enter hourly rate: $");
                rateHourWrkr = input.nextDouble();

                hourGross = rateHourWrkr * hoursWrkd;

                System.out.println("Name: "             + employeeName);
                System.out.println("Title: "            + employeeTitle);
                System.out.println("Type: "             + employeeType);
                // Begin checking hours worked
                if (hoursWrkd > 40)
                {
                    hourOvertimeStore = (hoursWrkd - 40) * rateHourWrkr * hourOvertime;
                    System.out.println("Hours worked: "     + hoursWrkd);
                    System.out.println("Overtime hours: " + (hoursWrkd - 40));
                    System.out.println("Gross pay: $"        + df.format(hourGross + hourOvertimeStore));
                    System.out.println("Federal Tax: $"      + df.format(hourGross * fedTax));
                    System.out.println("Social Security: $"  + df.format(hourGross * socialSec));
                    System.out.println("Medical: $"          + df.format(medicalDues));
                    fedTaxFinal = hourGross * fedTax;
                    socialSecFinal = hourGross * socialSec;
                    deductDues = (fedTaxFinal + socialSecFinal + medicalDues);
                    hourNet = (hourGross - deductDues);

                    System.out.println("Net pay: $"          + df.format(hourNet));
                }
                else
                {
                    hourGross = hoursWrkd * rateHourWrkr;
                    hourOvertimeStore = 0;
                    System.out.println("Hours worked: "     + hoursWrkd);

                    System.out.println("Gross pay: $"        + df.format(hourGross + hourOvertimeStore));
                    System.out.println("Federal Tax: $"      + df.format(hourGross * fedTax));
                    System.out.println("Social Security: $"  + df.format(hourGross * socialSec));
                    System.out.println("Medical: $"          + df.format(medicalDues));

                    fedTaxFinal = hourGross * fedTax;
                    socialSecFinal = hourGross * socialSec;
                    deductDues = (fedTaxFinal + socialSecFinal + medicalDues);
                    hourNet = (hourGross - deductDues);
                    System.out.println("Net pay: "          + df.format(hourNet));
                }
            }
            break;
            case 3:
            {
                employeeTitle = "Commission";
                System.out.println("You selected commission!");
                System.out.print("What's your name? :");
                employeeName = input.next();

                System.out.print("Enter the amount of hours worked this week: ");
                hoursWrkd = input.nextInt();

                System.out.println("Name: "             + employeeName);
                System.out.println("Title: "            + employeeTitle);
                System.out.println("Type: "             + employeeType);
                System.out.println("Hours worked: "     + hoursWrkd);


                commGross = rateCommWrkr + commBonus;
                commWklySal = (0.057 * rateCommWrkr);
                System.out.println("Commission made: $" + df.format(commWklySal));

                System.out.println("Gross pay: $"        + df.format(commWklySal + commGross));
                System.out.println("Federal Tax: $"      + df.format((commWklySal + commGross) * fedTax));
                System.out.println("Social Security: $"  + df.format((commWklySal + commGross) * socialSec));
                System.out.println("Medical: $"          + df.format(medicalDues));

                fedTaxFinal = (commWklySal + commGross) * fedTax;
                socialSecFinal = (commWklySal + commGross) * socialSec;
                deductDues = (fedTaxFinal + socialSecFinal + medicalDues);
                commNet = (commWklySal + commGross) - deductDues;
                System.out.println("Net pay: $"          + df.format(commNet));
            }
            break;
            case 4:
            {
                employeeTitle = "Pieceworker";
                System.out.println("You selected pieceworker!");
                System.out.print("What's your name? :");
                employeeName = input.next();

                System.out.print("Enter the amount of hours worked this week: ");
                hoursWrkd = input.nextInt();

                System.out.println("Name: "             + employeeName);
                System.out.println("Title: "            + employeeTitle);
                System.out.println("Type: "             + employeeType);
                System.out.println("Hours worked: "     + hoursWrkd);

                pieceGross = ratePieceWrkr;
                System.out.println("Gross pay: $"        + df.format(pieceGross));
                System.out.println("Federal Tax: $"      + df.format(pieceGross * fedTax));
                System.out.println("Social Security: $"  + df.format(pieceGross * socialSec));
                System.out.println("Medical: $"          + df.format(medicalDues));

                pieceNet = pieceGross - fedTax - socialSec - medicalDues;
                System.out.println("Net pay: $"          + df.format(pieceNet));
            }
            break;
            }

        }
        System.out.println("Thank you for using this Application");
    }
}