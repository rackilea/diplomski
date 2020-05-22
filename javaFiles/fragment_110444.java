import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {

    public static void main(String[] args) throws IOException {


        Scanner scanner = new Scanner(System.in);
        String classroom = scanner.nextLine().toLowerCase();
        BufferedReader input = new BufferedReader(new FileReader("data.txt"));
        String data = input.readLine();
        int subjectIndex = 10;
        String[] items = new String[0];
        boolean match=false;
        while (data != null) {
            items = data.split(",");

            if (items.length > 10) {
                if (items[subjectIndex].toLowerCase().contains(classroom)) {
                    System.out.println("There students in enrolling in "  +classroom+ " are " +items[0]+ " " + items[1] + " (" + items[2] +")");
                    match = true;
                }
            }
            data = input.readLine();
        }

        if(!match)
        {
            System.out.println("The subject " +classroom+ " is not taught at our school");
        }

    }
}