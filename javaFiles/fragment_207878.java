import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Test {
    public static String Question1(String fileName) {   
        String message = "";
        if ( fileName == null )
            fileName = "files/question1/sample.txt"; 

        try {  
            Scanner fileScan = new Scanner(new File(fileName));
            while (fileScan.hasNext()) {
                String readLine = fileScan.nextLine();
                if (message.equals("")) {
                    message = readLine + "\n";
                } else {
                    message = message + readLine + "\n";
                }
            }
        } catch (FileNotFoundException e) {
            message = "Error: Could not find file!";
        }

        return message;
    }

    public static void main(String[] args) {
        System.out.println(Question1("no_such_file.txt"));
    }
}