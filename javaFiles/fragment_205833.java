import java.util.*;
public class errorCheck{
    public static void main (String [] args) {

    //original sentence
    String sentence = "This test sentence should cut off properly at every 40th character and add any cut words to the next line.";

    //array to store each line
    ArrayList <String> words = new ArrayList<String>();

    //current line being filled
    String newLine = "";

    //individual character being read from the sentance string
    char character = ' ';

    //string to preserve any word severed when a new line is created
    String cutWord = "";

    //int to keep track of how many indexes to move over
    int cutAdd = 0;

    //char to keep track of the chars in the word being cut off at the end of the line
    char cutChar = ' ';

    int charsRead = -1;
    for (int i = 0; i < sentence.length(); i++){
        charsRead++;

        //examines the chars one by one in the sentance
        character = sentence.charAt(i);

        //makes sure each line is max 40 chars long
        if(charsRead >= 40 && i > 1){
            //if the char at the 40 mark is a space or coma, add it to the line and start a new line
            if (character == ' ' || character == ','){
                newLine += character;
                words.add(newLine);
                newLine = "";
            }
            //else (aka the line stops in the middle of a word)
            else{
                //sets temporary character and index to current one
                cutChar = character;

                //the following while loop searches for the last index in the string that was a space, therefore finding the beginning of the cut word. Also account for chance the index reaches the start of the string
                while(cutChar != ' ' && i > 0){
                    i--;
                    cutChar = sentence.charAt(i);

                    //minuses the line of the char to be added to the next line
                    newLine = newLine.substring(0, newLine.length() - 1);
                }

                //after exiting the loop, the string "cutWord" should be the full word cut between the two lines

                //adds the new line (minus the chars taken for the cut word) 
                words.add(newLine);
                newLine = "";
            } 

            charsRead = 0;
        }

        //This loop makes sure that the final char is always added
        else if (i == (sentence.length() - 1)){
            newLine += character;
            words.add(newLine);
        }

        //if no other condition is met, the current character is simplily added to newLine
        else{
            newLine += character;
        }
    }

    //after all that, there should be an arraylist with a line for each element
    String[] wordsArray = new String[words.size()];
    //turn that arraylist to a regular one (because ideally in the end it's going to be sent over somewhere else)
    wordsArray = words.toArray(wordsArray);

    //should print out the sentance in lines that are 40 chars or less
    for (int i = 0; i < wordsArray.length; i++){
        System.out.println(wordsArray[i]);
    }

}
}