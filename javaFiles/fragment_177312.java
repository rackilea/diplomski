import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Class that created a word-ladder between two words (if possible)
 * @author GJ
 * @version 4/27/2015
 */
public class LadderBuilder {

    private Collection<String> dictionary;
    private Collection<String> usedWords = new HashSet<String>();

    public LadderBuilder(Collection<String> dictionary) {
        this.dictionary = dictionary;
    }


    public Deque<String> buildLadder(String start, String end){

        LinkedList<String> temp = new LinkedList<String>();
        Queue<Stack<String>> wordQ = new LinkedList<Stack<String>>();
        Deque<String> ladder = new LinkedList<String>();
        if ( start.length() != end.length()){
            System.err.println("Selected words are not of the same length.");
            System.exit(1);
        }
        temp = (LinkedList<String>) getWordsOneAway(end);
        Iterator<String> myIter = temp.iterator();
        while(myIter.hasNext()){

            Stack<String> words = new Stack<>();
            words.push(end);
            words.push(myIter.next());
            wordQ.add(words);
        }

        for (int i = 0; i < wordQ.size(); i++){
            Stack<String> temp3 = wordQ.poll();
            i--;
            if(temp3.peek().equals(start)){
                for(String each:temp3){
                    ladder.add(each);
                }
                return ladder;
            } 
            else {
                LinkedList<String> temp2 = new LinkedList<String>();
                temp2 = (LinkedList<String>) getWordsOneAway(temp3.peek());
                for ( String nextWord:temp2){
                    @SuppressWarnings("unchecked")
                    Stack<String> nextTempStack = (Stack<String>) temp3.clone();
                    nextTempStack.push(nextWord);
                    wordQ.add(nextTempStack);
                }
            }
        }
        return null;

    }

    private List<String> getWordsOneAway(String word){
        usedWords.add(word);
        List<String> oneAwayList = new LinkedList<String>();
        for (int i = 0; i < word.length(); i++) {
            char[] currCharArr = word.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                currCharArr[i] = c;
                String newWord = new String(currCharArr);
                if (dictionary.contains(newWord) && !(usedWords.contains(newWord))) {
                    oneAwayList.add(newWord);
                    usedWords.add(newWord);
                }
            }
        }

        return oneAwayList;
    }

}