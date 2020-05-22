import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapExample {

static String fileName = "text.txt";
private static Scanner input;

public static void main(String[] args) throws FileNotFoundException {

    input = new Scanner(new File(fileName));

    Map<String, Integer> map = new HashMap<String, Integer>();

    while (input.hasNext()) {
        String word = input.next();
        if (map.containsKey(word)) {
            int temp = map.get(word) + 1;
            map.put(word, temp);
        } else {
            map.put(word, 1);
        }
    }

    System.out.println("printing longest word(s) with word count < 3");
    System.out.println("");

    // iterate through the key set and display word, word length and values
    System.out.printf("%-25s\t%-25s\t%s\n", "Word", "Word Length", "Count");

    String longest = getLongest(map);

    int valueOfLongest = 0;
    if (!longest.equals("")) {
        valueOfLongest = longest.length();
        System.out.printf("%-25s\t%-25s\t%s\n", longest, longest.length(), map.get(longest));
        map.remove(longest);
    }


    boolean isAllRemoved = false;
    while (!isAllRemoved) {
        isAllRemoved = false;
        longest = getLongest(map);
        if (!longest.equals("") && longest.length() == valueOfLongest){
            System.out.printf("%-25s\t%-25s\t%s\n", longest, longest.length(), map.get(longest));
            map.remove(longest);
        } else
            isAllRemoved = true;
    }

    System.out.println("");
    System.out.println("printing next longest word(s) with word count > = 3");
    System.out.println("");

    // iterate through the key set and display word, word length and values
    System.out.printf("%-25s\t%-25s\t%s\n", "Word", "Word Length", "Count");

    String nextLongest = getNextLongest(map, valueOfLongest);

    int valueOfNextLongest = 0;
    if (!longest.equals("")) {
        valueOfNextLongest = nextLongest.length();
        System.out.printf("%-25s\t%-25s\t%s\n", nextLongest, nextLongest.length(), map.get(nextLongest));
        map.remove(nextLongest);
    }

    boolean isNextLongest = false;
    while (!isNextLongest) {
        isNextLongest = true;
        nextLongest = getNextLongest(map, valueOfLongest);
        if (!(nextLongest.equals("")) && nextLongest.length() ==  valueOfNextLongest) {
            System.out.printf("%-25s\t%-25s\t%s\n", nextLongest, nextLongest.length(), map.get(nextLongest));
            map.remove(nextLongest);
            isNextLongest = false;
        }

    }

}

public static String getLongest(Map<String, Integer> map) {
    String longest = "";
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
        String key = (String) entry.getKey();
        if (longest.length() < key.length() && map.get(key) < 3) {
            longest = key;
        }

    }

    return longest;
}

public static String getNextLongest(Map<String, Integer> map,
        int valueOfLongest) {
    String nextLongest = "";
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
        String key = (String) entry.getKey();
        if (valueOfLongest > key.length() && nextLongest.length() < key.length() && map.get(key) >= 3) {
            nextLongest = key;
        }

    }

    return nextLongest;
}
}