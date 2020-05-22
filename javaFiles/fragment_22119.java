import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class ReadFileJava {
    public static void main(String[] args) {
        //list that stores all greens 
        ArrayList<String> greens = new ArrayList<String>(); 

        //list that stores all reds
        ArrayList<String> reds = new ArrayList<String>(); 

        //file that references the file containing all green and red apples
        File file = new File("C:\\test_java\\apples.dat");

        //try and catch block in case file not found or any other I/O error
        try {

            //open the file
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            //keep reading line by line, if end of file then line == null
            while ((line = br.readLine()) != null) {

                //if line contains "d" then Green it is and add it
                //to the list of reds
                if(line.indexOf("d") != -1) {
                    System.out.println("Green found!");
                    greens.add(line); 
                } else {
                    //add it to the list of superheors.
                    System.out.println("Red found.");
                    reds.add(line); 
                }
            }

            //close the reading file resource 
            br.close();

            //file to print greens back 
            File greensFile = new File("C:\\test_java\\greens.dat"); 

            //file to print reds
            File redsFile = new File("C:\\test_java\\reds.dat"); 

            //PrintStream takes care of open stream to files above
            //and writing line by line, first write greens 
            PrintStream output = new PrintStream(redsFile);

            //loop through list of previously created greens
            for(int i = 0; i < greens.size(); i++) {
                //write hered to file
                output.println(reds.get(i));
            }

            //redirect the print stream to greens file 
            output = new PrintStream(greensFile);

            //loop through list of greens
            for(int i = 0; i < greens.size(); i++) {
               //add green to the file 
                output.println(greens.get(i));
            }

            //close the output stream
            output.close();
        } catch (IOException e) {
            //if file not found, or any other I/O error, then error
            //so check the location of file
            e.printStackTrace();
        }
    }
}