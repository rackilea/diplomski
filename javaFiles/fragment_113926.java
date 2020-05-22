import java.util.Objects; 
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class AccountTester { 
    public static void main (String[] args) {

        Scanner scnr;
        try {
            File file = new File("/path/to/your/file/input.csv");
            scnr = new Scanner(file);
        } catch (FileNotFoundException e){
            System.out.println("Input file not found");
            return;
        }

        scnr.useDelimiter(",|\\n");
        String str1 = "p", str2, str3, str4, str5, str6;

        while(scnr.hasNext()){

            str1 = scnr.next();

            if(str1.equals( "q")) {
                System.out.println(str1);
                break;
            }

            str2 = scnr.next();
            str3 = scnr.next();
            str4 = scnr.next();
            str5 = scnr.next();
            str6 = scnr.next();

            System.out.println(str1 + " " + str2 + " " + str3 + " " + str4 + " " + str5 + " " + str6);       

        }

        scnr.close();
    }
}