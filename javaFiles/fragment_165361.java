import java.util.Scanner;
import java.io.*;

public class FileCount{

    public static void main(String[] args) throws IOException{


      // check number of command line arguments, and check it in main()
       if(args.length != 1){
            System.err.println("Usage: LineCount file");
            System.exit(1);
        }

    Scanner in = new Scanner(new File(args[0]));
    System.out.println( args[0]+" contains "+lineCount(in)+" lines" ); //call this line in main() and not in linecount() as you refer to both args and need the linecount.

    }

    public static int lineCount(Scanner in){


        // count lines, words, and chars in file
        int lineCount = 0;
        while( in.hasNextLine() ){
            in.nextLine();
            lineCount++;
        }
        in.close();

        return lineCount; //return the linecount from method 

    }

}