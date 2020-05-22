package lettercount;
import java.util.*;
import java.io.*;

//Version that demonstrates using a map to keep a running count for items encountered
//This way you only have to step through the input once.
public class ProgrammingAssignment {

public static void main(String[] args) throws IOException {
    BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Enter Any Text: ");
    String output = BR.readLine();
    output=output.toLowerCase();

    int length = output.length();
    char character;
    int totalCount = 0;

    //we'll store each encountered character in this map, along with a count of the number
    //of times encountered.
    Map<Character, Integer> map = new HashMap<Character,Integer>();

    //Loop over the output once, character by character
    for (int i = 0; i < length; i++)
    {
        character = output.charAt(i);
        totalCount++; //This is the total number of characters we've found in the output

        Integer countForCharacter = 0;
        //check in map if we have a count for this character
        if (map.containsKey(character)) {
            //get the current count we have for this character
            countForCharacter = map.get(character);
            //increment
            countForCharacter++;
            //increment the count
        } else {
            countForCharacter = 1;
        }

        //Now put the up to date count into the map
        map.put(character, countForCharacter);
    }


    //Get the found characters as an array of Character
    Character[] charactersFound = map.keySet().toArray(new Character[0]);

    System.out.println("Letters\tFrequency\tCount");
    for(int k = 0; k < charactersFound.length; k++)
    {
        character = charactersFound[k];
        System.out.println(character+
                "\t" +
                //Following line gets the count for the character and divides by totalCount,
                //making sure that the the result is a floating point
                (map.get(character)/((float)totalCount)) +
                "\t"+
                //get the count for the character
                map.get(character));
    }
}