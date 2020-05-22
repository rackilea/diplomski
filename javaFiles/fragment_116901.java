public class Quizzes {

    public static void main(String[] args) {

        double Q1, Q2, Q3, Q4, Q5;
        double average = 0;
        double lowest = 0;

        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter Quizzes: ");
        System.out.println("");
        Q1 = keyboard.nextDouble();
        Q2 = keyboard.nextDouble();
        Q3 = keyboard.nextDouble();
        Q4 = keyboard.nextDouble();
        Q5 = keyboard.nextDouble();
        keyboard.close();

        average = (Q1 + Q2 + Q3 + Q4 + Q5) / 5;
        System.out.println("Average Score is: " + average);

        if (Q1 <= Q2 && Q1 <= Q3 && Q1 <= Q4 && Q1 <= Q5) {
            lowest = Q1;
        } else if (Q2 <= Q1 && Q2 <= Q3 && Q2 <= Q4 && Q2 <= Q5) {
            lowest = Q2;
        } else if (Q3 <= Q1 && Q3 <= Q2 && Q3 <= Q4 && Q3 <= Q5) {
            lowest = Q3;
        } else if (Q4 <= Q1 && Q4 <= Q2 && Q4 <= Q3 && Q4 <= Q5) {
            lowest = Q4;
        } else if (Q5 <= Q1 && Q5 <= Q2 && Q5 <= Q3 && Q5 <= Q4) {
            lowest = Q5;
        }

        System.out.println("The lowest score is: " + lowest);
        // THEN DO SIMILAR TO GET HIGHEST SCORE
    }
}