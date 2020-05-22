Hashtable<String, Word> words = new Hashtable<String, Word>();

public void addWord(String s) {
    if (words.containsKey(s) {
        words.get(s).plusOne();
    } else {
        words.put(s, new Word(s));
    }
}