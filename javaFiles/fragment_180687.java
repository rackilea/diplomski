package addtext;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Dan300
 */
public class AddText {

    File yourFile = new File("YourFileHere.txt"); //add the name of your file in the brackets
    int numLines; //this will store the number of lines in the file
    String[] lines; //the lines of text that make up the file will be stored here

    public AddText() {
        numLines = getNumberLines(yourFile);
        lines = new String[numLines];//here we set the size of the array to be the same as the number of lines in the file
        for(int count = 0; count < numLines; count++) {
            lines[count] = readLine(count,yourFile);//here we set each string in the array to be each new line of the file
        }

        doSomethingToStrings();
    }

public static void main(String[] args) {
        new AddText();
    }