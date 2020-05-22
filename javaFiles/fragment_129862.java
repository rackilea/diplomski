import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to average grade calculation service!");
        String userChoice = null;

        do {
                int numberOfGrades = getNumberOfGrades(input);
                double averageGrade = getGradeAvg(numberOfGrades, input);
                System.out.printf("\nThe average grade is %4.2f\n",  averageGrade);
                System.out.print("\nDo you want to continue (yes/no)? ");
                userChoice = input.nextLine();
                System.out.println("");

            } while (userChoice.equalsIgnoreCase("yes")); 

        System.out.println("Thank you and have a nice day!");
        input.close();
    }

    //this method is responsible of getting the number of grades
    private static int getNumberOfGrades(Scanner input) {

        int numberOfGrades = 0;
        boolean isCorrectNumber;

        do {
            isCorrectNumber = false;

            System.out.print("\nEnter the number of grades: ");

            if (!input.hasNextInt()) {
                System.out.println("Error: The number of grades must be a number.");
                input.nextLine();
            } else {
                numberOfGrades = input.nextInt();
                if (numberOfGrades < 0) {
                    System.out.println("Error: The number of grades must be positive.");
                } else
                    isCorrectNumber = true;
            } 
        } while (!isCorrectNumber);

        return numberOfGrades;
    }

    /*
     * this method takes the number of grades as a parameter
     * then asks the user to input grade value of each grade
     * then it calculate the average and returns the value
     */
    private static double getGradeAvg(int numberOfGrades, Scanner input) {

        double sumOfGrades = 0;
        boolean isCorrectNumber;
        double aGrade = 0;

        for (int i = 1; i <= numberOfGrades; i++) {

            isCorrectNumber = false;

            do {
                System.out.print("Enter grade " + i + ": ");

                if (!input.hasNextDouble()) {

                    System.out.println("Error: The grade must be a number.");
                    input.nextLine();
                } else {
                    aGrade = input.nextDouble();

                    if (aGrade < 0) {
                        System.out.println("Error: The grade must be zero or positive.");
                    } else {
                        isCorrectNumber = true;
                    }
                }
            } while (!isCorrectNumber);

            sumOfGrades += aGrade;
        }

        double averageGrade = (sumOfGrades > 0)? sumOfGrades / numberOfGrades : 0;
        return averageGrade;
    }
}