import static java.lang.System.*;

import java.util.Arrays;

public class Word
{
    private static String vowels = "AEIOUaeiou";   //only one


    public static int getNumVowels(String word)
    {
        int count=0;
        for (int i=0; i < word.length(); i++)
        {
            // check if selected char is a vowel
            if (vowels.contains(word.charAt(i) + ""))
            {
                count ++; // same as count = count + 1
            }
        }
        return count;
    }

}