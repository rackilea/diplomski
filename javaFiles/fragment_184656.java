import java.util.*;
import java.io.*;
public class HangmanProject{
   public static void main(String[] args) throws FileNotFoundException{ //this is the first thing that runs, the main method
      GetFile gf = new GetFile();  //this will create the getFile object
      try {
         gf.getWords(); //runs the method that we make later
      }
      catch(FileNotFoundException potatoes) {   //this will print out error message if there is no words.txt
         System.out.println(potatoes.getMessage());
      }                                
    } //closes main method
}