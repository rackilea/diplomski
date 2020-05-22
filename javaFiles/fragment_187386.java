import java.util.Scanner;

class Pacient {
    private static Scanner input;

    public static void main(String args[]) {
        int numberOfPatients; // Variables that saves number of patient
        // Asking user the number of patients
        input = new Scanner(System.in);
        System.out.print("How many patients do you want?: ");
        // I have change this to nextInt
        // From javadoc "Scans the next token of the input as an int"
        // It is essentially next() + parseInt()
        numberOfPatients = input.nextInt();
        // nextInt() does not move cursor to next line
        // using nextLine() here would move it to next line and close
        // previous line otherwise it creates issue when you will use next/nextLine again
        input.nextLine();

        // String[][] array = new String[Rows][Columns];
        // For each patient there is a row. Since in the code there is header
        // as well that's why we need numberOfPatients + 1
        String[][] bmi = new String[numberOfPatients + 1][5]; 

        // All corresponding columns  
        bmi[0][0] = "Name"; // First line of final table NAME
        bmi[0][1] = "Weight"; // WEIGHT
        bmi[0][2] = "Height"; // HEIGHT
        bmi[0][3] = "BMI"; // BMI based on calc.
        bmi[0][4] = "Result"; // Final result

        // Starting from 1. Skipping header 
        for (int y = 1; y <= numberOfPatients; y++) {
            // Using y instead of an int. This way the loop will
            // automatically move to next row

            // Instead of saving it to variable and then to array 
            // I am saving it directly
            System.out.print("Enter your first name: ");
            bmi[y][0] = input.nextLine();

            System.out.print("Enter your weight in Kg: ");
            bmi[y][1] = input.nextLine();

            System.out.print("Enter your height in m: ");
            bmi[y][2] = input.nextLine();

            // Using the information from above to calculate BMI
            // Basically I am storing and calculating at the same time
            // parseDouble converts String into double 
            // Math.pow(a,b) is powber function. a is base and b is exponent 
            double weight = Double.parseDouble(bmi[y][1]);
            double heightSquare = Math.pow(Double.parseDouble(bmi[y][2]), 2);
            double bmiCalculated = weight / heightSquare;

            // Based on BMI assigning result in result column
            bmi[y][3] = bmiCalculated + "";
            if (bmiCalculated < 18.5) {
                bmi[y][4] = "You are underweight";
            } else if (bmiCalculated > 18.5 && bmiCalculated < 25) {
                bmi[y][4] = "You are normal";
            } else if (bmiCalculated > 25 && bmiCalculated < 30) {
                bmi[y][4] = "You are overweight";
            } else {
                bmi[y][4] = "You are obese";
            }
            System.out.println("Your information has been saved successfully!");
        }

        System.out.println("--------------------------------------------------");

        // In java 2D arrays are multiple 1D array stacked on each other
        // bmi.length gives the number of rows
        // Basically you iterate through each row and print each individual row
        // like 1D array
        for (int i = 0; i < bmi.length; i++) {
        // bmi[i] gives ith row. Which is 1D array. So you can print it like normal array
            for (int j = 0; j < bmi[i].length; j++)
                System.out.print(bmi[i][j] + " ");
            System.out.println();
        }
        System.out.println("--------------------------------------------------");
    }
}