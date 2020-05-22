import java.util.ArrayList;
import org.junit.Test;

public class StackOverflow_32878663 {

    @Test
    public void replaceBlacklistedWords()
    {

        // mimicking your list of strings from the file
        ArrayList<String> wordList = new ArrayList<String>();
        wordList.add("replace: blue");
        wordList.add("replace: green");
        wordList.add("replace: red");
        wordList.add("replace: white");
        wordList.add("replace: yellow");

        String incomingMessage = "I am RED, white, bLuE, and green all over.  What am I?";
        String modifiedMessage = incomingMessage;

        for (String s : wordList)
        {
            // one way of many to remove "replace:" if that is important
            String justTheWord = s.split(" ", 2)[1];  

            // the (?i) tells the regex to perform in a case insensitive manner
            modifiedMessage = modifiedMessage.replaceAll("(?i)" + justTheWord, " ");  
        }

        System.out.println("Original message: " + incomingMessage);
        System.out.println("Modified message: " + modifiedMessage);
    }

}