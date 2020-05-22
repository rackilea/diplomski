import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;



public class GAMESCORE {

private static char[] input;

public static void main(String[] args) {

    int totalGames, totalAchievements, totalTime;

    totalGames = 0;
    totalAchievements = 0;
    totalTime = 0;

    String gamerName, gamerReport;

    @SuppressWarnings("resource")
    Scanner Scan = new Scanner(System.in);


    System.out.println("-------------- Game Score Report Generator --------------");
    System.out.println("     ");


    System.out.println("Enter Your Name");
    gamerName = Scan.nextLine();
    boolean isEmpty = gamerName == null || gamerName.trim().length() == 0;

    if (isEmpty) {

        System.out.print("Enter your Name.");

        gamerName = Scan.nextLine();
    }



    System.out.println("Enter details in this format - " + " -->");
    System.out.println("    ");



    System.out.println("Game : Achievement Score : Minutes Played");
    gamerReport = Scan.nextLine();
    Scanner scanner = new Scanner(System.in);

    List<String> al = new ArrayList<String>();
    String word;
    while (scanner.hasNextLine()) {
        word = scanner.nextLine();
        if (word != null) {
            word = word.trim();
            if (word.equalsIgnoreCase("quit")) {
                break;
            }
            al.add(word);
        } else {
            break;
        }
    }




    try
    {

        PrintWriter writer = new PrintWriter(new FileOutputStream("Gaming Report Data.txt", true));

        writer.println("Player : " + gamerName);
        writer.println();
        writer.println("--------------------------------");
        writer.println();
        for(String listString : al){
            String[] splitUpReport;
            splitUpReport = listString.split(":");

            writer.println("Game: " + splitUpReport[0].trim() + ", score= " + splitUpReport[1].trim() + ", minutes played= " +splitUpReport[2].trim());

            totalGames++;
            totalTime += Integer.parseInt(splitUpReport[2].trim());
            totalAchievements += Integer.parseInt(splitUpReport[1].trim());
        }

        writer.println();
        writer.println("--------------------------------");
        writer.println();
        writer.println("Games Played: " + String.valueOf(totalGames));
        writer.println("Total Achievement: " + String.valueOf(totalAchievements));
        writer.println("Total Time: " + String.valueOf(totalTime) + " (" + String.valueOf(totalTime/60) + " hours and " + String.valueOf(totalTime%60) + " minutes)");
        //writer.println("Games Played : " + minutesPlayed);
        writer.close();





    } catch (IOException e)
    {
        System.err.println("You have made an error with data input");
    }



    System.out.println("You have quit!");
}





public static char[] getInput() {
    return input;
}

public static void setInput(char[] input) {
    GAMESCORE.input = input;
}

}