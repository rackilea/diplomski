public class WordList {
    static List<Word> words = new ArrayList<Word>();
    public static void countWord(String inputWord) {
        for (Word word : words) {
            if (word.getWord().equals(inputWord)) {
                word.setCount(word.getCount() + 1);
            } else {
                Word newWord = new Word();
                newWord.setWord(inputWord);
                newWord.setCount(1);
                words.add(newWord);
            }
        }
    }
}