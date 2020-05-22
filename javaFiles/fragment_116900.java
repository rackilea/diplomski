public class Quizzes {

    public static void main(String[] args) {

        double Q1, Q2, Q3, Q4, Q5;
        double average = 0;
        double max = 0;
        double count = 0;
        double[] userInput = new double[5];

        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter Quizzes: ");
        System.out.println("");
        Q1 = keyboard.nextInt();
        userInput[0] = Q1;
        Q2 = keyboard.nextInt();
        userInput[1] = Q2;
        Q3 = keyboard.nextInt();
        userInput[2] = Q3;
        Q4 = keyboard.nextInt();
        userInput[3] = Q4;
        Q5 = keyboard.nextInt();
        userInput[4] = Q5;
        keyboard.close();

        for (int i = 0; i < userInput.length; i++) {
            count = count + userInput[i];
            average = count / 5;
        }
        System.out.println("Average Score is: " + average);
        Arrays.sort(userInput);
        System.out.println("The lowest score is: " + userInput[0]);
        max = userInput[userInput.length - 1];
        System.out.println("The highest score is: " + max);
    }

}