import java.util.Scanner;

public class GradeCalculator {



//Maximum number of grades
    private static final int NUM_SCORES = 5;
    public void readGrade() {

        Scanner keyboard = new Scanner(System.in);
        // declaring the variables.
        int sum = 0;

        System.out.println("Welcome to the grade calculator , please Enter a grade between 0-101 ");
        System.out.println("And press enter key on your keyboard to type the next score:");

        for (int i = 0; i < NUM_SCORES; i++) {
            int testScore;
            do {
                System.out.println("Please enter your test score:");
                testScore = keyboard.nextInt();
                //if the score is not correct: Output Error
                if (testScore < 0 || testScore > 101)
                    System.err.println("Wront input. Inpute the test score again!");
                else{
                    //if the score is correct, then add the score to the sum
                    sum += testScore;
                }
                //repeat if the score is not correct, to get a correct score
            }while (testScore < 0 || testScore > 101);
        }
        //The average is the sum of the scores divided by the number of scores
        System.out.println("Your grade average is :" + sum/NUM_SCORES);

        keyboard.close();
    }

    public static void main(String[] args) {

        new GradeCalculator().readGrade();

    }
}