import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WinsFileManager {

    String path = System.getProperty("user.home").replace("\\", "\\\\") + "\\";

    public int getWins(String fileName) {

        String fullPath = path + fileName;
        int wins = 0;

        try {
            wins = Integer.parseInt(new Scanner(new File(fullPath)).nextLine());
        } catch (NumberFormatException e) {} 
          catch (FileNotFoundException e) {
            wins = 0;
        }

        return wins;
    }

    public void saveWins(String fileName, int wins) {
        PrintWriter out = null;

        try {
            out = new PrintWriter(path + fileName, "UTF-8");
            out.println(wins);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}