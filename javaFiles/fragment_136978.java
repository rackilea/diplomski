import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner fromFile = new Scanner(new File("id_name.txt"));
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }

        String[] arr = new String[9];
        String[] oth = new String[9];
        int i = 0;

        while(fromFile.hasNextLine()) {
            String temp = fromFile.nextLine();
            oth[i] = temp.substring(0,1);
            arr[i] = temp.substring(2);
            i++;
        }

        int[] fileID;
        fileID = new int[9];

        for(int j = 0; j < 9; j++) {
            fileID[j] = Integer.parseInt(oth[j]);
        }
    }
}