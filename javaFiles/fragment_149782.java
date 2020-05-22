import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Project4 {

    private static void printGame() {
        for (char[] row : GameOfLife.grid) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in); // Created a scanner
        System.out.println("Enter the file name you would like to use");
        File file = new File(input.nextLine()); // Takes file name to find file
        BufferedReader br = null;
        String line;
        int i = 0;

        try {
            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
                for (int col = 0; col < line.length(); col++) {
                    GameOfLife.grid[i][col] = line.charAt(col);
                }
                i++;
                if (i == 25) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
        }

        // Prints the initial environment
        System.out.println("Initial set: ");
        printGame();

        while (true) {
            System.out.println("Do you want to see the next generation? Y/N?");
            String q = input.nextLine();
            if (q.equalsIgnoreCase("y")) {
                GameOfLife.evolve();
                printGame();
            } else {
                System.exit(0);
            }
        }
    }
}