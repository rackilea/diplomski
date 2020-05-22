import java.io.*;
import java.util.Scanner;

public class TextReader
{
    private static int numOfOccurrences;         //Counter to keep track of the number of occurances
    private static String wordToSearchFor;       //String field so both methods can access it

    /*
    * This method takes in the file of the book so the scanner can look at it
    * and then does all of the calculating to see if the desired word appears,
    * and how many times it does appear if it does appear
    */

    public static void wordCounter(File bookInput)
    {
        try                                         
        {                                               
            Scanner bookAnalyzer = new Scanner(bookInput);     //Scanner for the book

            while(bookAnalyzer.hasNext())                      //While the scanner has something to look at next
            {
                String wordInLine = bookAnalyzer.next();        //Create a string for the next word

                wordInLine = wordInLine.toLowerCase();          //Make it lowercase
                String wordToSearchForLowerCase = wordToSearchFor.toLowerCase();
                String wordToSearchForLowerCasePeriod = wordToSearchForLowerCase + ".";

                if(wordInLine.indexOf(wordToSearchForLowerCase) != -1 && wordInLine.length() == wordToSearchFor.length())
                {
                    numOfOccurrences++;
                }
                else if(wordInLine.indexOf(wordToSearchForLowerCasePeriod) != -1 && wordInLine.length() == wordToSearchForLowerCasePeriod.length())
                {
                    numOfOccurrences++;
                }
            }
        }

        catch(FileNotFoundException e)               //Self explanitory
        {
            System.out.println("The error is FileNotFoundException - " + e);
            System.out.println("This should be impossible to get to because error checking is done before this step.");
        }
    }