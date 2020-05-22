import java.util.Scanner;
    public class Practise {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Please enter player name: ");
    String playerName = input.nextLine();
    System.out.println("Please enter player score: ");
    int score = input.nextInt();
    int finalScore = calculateSection(score);
    displayM(playerName , finalScore , score);
}

public static void displayM(String playerName,int finalScore, int score) {
    System.out.println("Player name is " + playerName + " score was " + score+ " position is "+finalScore);
}

public static byte calculateSection(int score) {
    if (score >= 1000) {
        return 1;
    } else if (score >= 500 && score < 1000) {
        return 2;
    } else if (score >= 400 && score < 500) {
        return 3;
    } else {
        return 4;
    }

}