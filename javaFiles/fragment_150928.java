import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class WordInAssay {

    Map<String,List<Integer>>  wordsMap;

    public WordInAssay(List<String> words) {

        //check that word is not null

        for(String word : words) {

            //map each word to a list. later store indices in that list.
            //using map will also eliminate identical words, if entered
            wordsMap.put(word, new ArrayList<Integer>());
        }

        search();
    }

    private void search() {

        //use populated map to do the work you want. 
    }
}