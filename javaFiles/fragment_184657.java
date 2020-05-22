import java.util.*;
import java.io.*;
public class GetFile {        
    //Here are your variables
    private String[] wordList = new String[10];   
    private int x = 0;                             
    //good practice to have variables private;
    //Now it is time for the constructor.
    public GetFile() 
       { 
     //empty constructor; you don't need to have any instance variables declared.
       } 
    public void getWords() throws FileNotFoundException {  //the big method for doing stuff
        Scanner keyboard = new Scanner(System.in);    // to read user's input
        System.out.println("Welcome to Hangman Project!");
        Scanner wordScan = null;
        wordScan = new Scanner(new File("words.txt"));
        while (wordScan.hasNext()) { //checking if there are more words
            wordList[x] = wordScan.next();  
            System.out.println(wordList[x]);  //print them out as the array is filled
            x++;  
            }
        if (wordScan != null)
           {
           wordScan.close(); //close the file after you are finished
           }
    }
}