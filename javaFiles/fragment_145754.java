import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Projects {
    public static void main (String[] args) throws Exception
    {
        BufferedReader dictionaryList = new BufferedReader( new FileReader( args[0] ) );
        BufferedReader scrambleList = new BufferedReader( new FileReader( args[1] ) );

        Map<String, List<String>> dWordMap = new HashMap<>();

        while (dictionaryList.ready()) {
            String word = dictionaryList.readLine();
            dWordMap.put(createKey(word), new ArrayList<>());
        }

        dictionaryList.close();

        while (scrambleList.ready()) {
            String scrambledWord = scrambleList.readLine();
            String key = createKey(scrambledWord);
            List<String> list = dWordMap.get(key);
            list.add(scrambledWord);
        }

        scrambleList.close();

        for (Map.Entry<String, List<String>> entry : dWordMap.entrySet()) {
            String word = entry.getKey();
            List<String> words = entry.getValue();
            Collections.sort(words);
            System.out.println(concatList(words, " ") + " " + word );
        }
    }

    private static String createKey(String word) {
        char[] characterWord = word.toCharArray();
        Arrays.sort(characterWord);
        return new String(characterWord);
    }

    private static String concatList(List<String> list, String delimiter) {
        StringJoiner joiner = new StringJoiner(delimiter);
        list.forEach(joiner::add);
        return joiner.toString();
    }
}