import java.io.File;
import java.net.URI;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args)throws Exception {
        File MovieFile= new File("TheMovieList.txt");
        Scanner ms = new Scanner(MovieFile);
        int count = 0;
        while (ms.hasNextLine()) {
            count++;
            ms.nextLine();
        }
        System.out.println("Number of lines in the file is " + count);
    }
}