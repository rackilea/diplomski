import java.util.Scanner;

public class ScoreTally {

public static void main(String[] args) {
    Scanner input = new Scanner(System.in);


    int aCount = 0;
    int bCount = 0;
    int cCount = 0;
    int dCount = 0;
    int fCount = 0;
    int scoreCount = -1;

    double score;
    double totalScore = 0;
    double bestScore = -1;


    do {
        System.out.println("Number of A's: " + aCount);
        System.out.println("Number of B's: " + bCount);
        System.out.println("Number of C's: " + cCount);
        System.out.println("Number of D's: " + dCount);
        System.out.println("Number of F's: " + fCount);
        System.out.print("Enter a score (%) or -1 to end: ");
        score = input.nextDouble();
        if (score >= 90) {
            aCount++;
        } else if ((score < 90) && (score >= 80)) {
            bCount++;
        } else if ((score < 80) && (score >= 70)) {
            cCount++;
        } else if ((score < 70) && (score >= 60)) {
            dCount++;
        } else if ((score < 60) && (score > 0)) {
            fCount++;
        }
        scoreCount++;
        totalScore = totalScore + score;
        bestScore = greaterNumber(bestScore, score);


    } while (score != -1);

    printGraph('A', aCount);
    printGraph('B', bCount);
    printGraph('C', cCount);
    printGraph('D', dCount);
    printGraph('F', fCount);
    System.out.println("Number of scores: " + scoreCount);
    System.out.println("Average scores: " + totalScore / scoreCount);
    System.out.println("Best scores: " + bestScore);

}

public static void printGraph(char grade, int count) {
    System.out.print("Number of " + grade + "'s: ");
    for (int i = 0; i < count; i++) {
        System.out.print("*");
    }
    System.out.println();
}

public static double greaterNumber(double firstNum, double secondNum) {
    if (firstNum >= secondNum) {
        return firstNum;
    } else {
        return secondNum;
    }
}