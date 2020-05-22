import java.io.File;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class test3 {
    public static void main(String[] args) throws Exception {
        File file = new File("file.dat");
        try {
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                string currentLine = input.nextLine();
                string[] currentLineArray = currentLine.split(" ");
                if ("p".equals(currentLineArray[0])) {
                    System.out.println("got p!");
                    if(currentLineArray.length == 4){
                        String x = currentLineArray[1];
                        String y = currentLineArray[2];
                        String z = currentLineArray[3];
                        System.out.println("x, y, z of p command are: " + x + ", " + y + ", " + z);
                    } else {
                        System.out.println("Incorrect number of arugments for command p!")
                    }
                }
            }
        }
    }
}