public class ArrayOperationDriver {
    public static void main(String[] args) {
        int [] testScores = {80, 90, 58, 75, 85, 45, 68, 72, 95};
        ArrayOperations object = new ArrayOperations();
        System.out.println("Average number is: " + object.getAverage(testScores));
        System.out.println("Highest number is: " + object.getHighest(testScores));

        System.out.print("The test scores are: ");
        for (int score : testScores) 
            System.out.print(score + " ");
        System.out.println("");
    }
}