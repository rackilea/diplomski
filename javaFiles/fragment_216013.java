package stackoverflow;
import java.util.Scanner;
public class C3484209 {
public static void main(String[] args) {

    String[] home_team_name = new String[100];
    String[] away_team_name = new String[100];
    String[] home_team_score = new String[100];
    String[] away_team_score = new String[100];

    Scanner keyboard = new Scanner(System.in);

    String line = "";

    int k = 0;
    while (!(line.equalsIgnoreCase("stop"))) {

        System.out.println("Enter the teams that played and the score :");
        System.out.println(
                "(Please note that the standard format is Home team : Away Team : Home Score : Away Score)");
        line = keyboard.nextLine();

        String[] elements = line.split(": ");

        for (int i = 0; i < elements.length; i++) {
            if ((int) i == 0) {
                home_team_name[k] = elements[i];

            } else if ((int) i == 1) {
                away_team_name[k] = elements[i];

            } else if ((int) i == 2) {
                home_team_score[k] = elements[i];

            } else if ((int) i == 3) {
                away_team_score[k] = elements[i];

            }
        }
        System.out.println(home_team_name[k] + " [" + home_team_score[k] + "]" + " | " + away_team_name[k] + " ["
                + away_team_score[k] + "]");
        k++;

    }
    keyboard.close();
}