import java.util.*;

public class test
{
    static Scanner sc = new Scanner(System.in);

    // add all the words you need into this array
    static String [] wordArr = new String[] { "yes", "hello", "boo" };

    // this converts the array to a List
    static final List<String> WORDS 
          = new ArrayList<String>(Arrays.asList(wordArr));

    public static void main(String[] args)
    {
        System.out.println("Choose a word");
        String userEntry = sc.next().toLowerCase();

        // check if the word is in the list
        if (WORDS.contains(userEntry))
        {
            System.out.println("We found a match");
        }
        else
        {
            System.out.println("We did not find a match");
        }
    }
}