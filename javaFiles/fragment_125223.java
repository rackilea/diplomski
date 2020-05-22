import java.util.*;
import java.lang.Iterable;

public class Main {

    String words;

    public static void main(String[] args) {

        Main plato = new Main(
                "You can discover more about a person in an hour of play than in a year of conversation");
        Main roosevelt = new Main(
                "When you play play hard when you work dont play at all");
        String[] platoArray = plato.getWordArray();
        String[] rooseveltArray = roosevelt.getWordArray();
        plato.printArray(platoArray);
        roosevelt.printArray(rooseveltArray);
        System.out.println("____________________________________________________");
        HashSet<String> rooseveltWordSet = roosevelt.getWordSet(platoArray);
        roosevelt.printArray(rooseveltWordSet);
        System.out.println("____________________________________________________");
        roosevelt.printArray(roosevelt.getWordCounts());
        System.out.println("____________________________________________________");

    }

    public Main(String word) {
        words = word.toLowerCase();
    }

    protected String[] getWordArray() {
        String[] wordArray = words.split(" ");
        return wordArray;
    }

    protected HashSet<String> getWordSet(String[] groupedWords)

    {
        HashSet<String> wordSet = new HashSet<String>();
        for (String string : groupedWords) {
                wordSet.add(string);
        }

        String[] wordArray = getWordArray();
        for (String string : wordArray) {
                wordSet.add(string);

        }
        return wordSet;
    }

    protected void printArray(String[] array) {
        for (String string : array) {
            System.out.println(string);
        }
    }
    protected void printArray(HashSet<String> hashWords)
    {
        for(String hashset: hashWords)
        {
            System.out.println(hashset);
        }
    }
    /*Changed*/
    protected void printArray(HashMap<String, Integer> printHashMap)
    {
        for(String string: printHashMap.keySet())
        {
            System.out.println(string + ":" + printHashMap.get(string) );
        }
    }

    /*changed*/
    protected HashMap<String, Integer> getWordCounts()
    {

        String[] wordArray = getWordArray();

        HashMap<String, Integer> wordCounts = new HashMap<String, Integer>();
        for(String string: wordArray)
        {
            if(wordCounts.containsKey(string)){
                wordCounts.put(string, wordCounts.get(string) + 1);
            }else{
                wordCounts.put(string, 1);
            }

        }

        return wordCounts;

    }
}