public class WordGroup {

    String  word;

    // Creates constructor which stores a string value in variable "word" and converts this into lower case using
    // the lower case method.
    public WordGroup(String aString) {

        this.word = aString.toLowerCase();
    }

    public String[] getWordArray() {

        String[] wordArray = word.split("-");
        return wordArray;
    }

    public HashMap<String, Integer> getWordCountsMap() {

        HashMap<String, Integer> myHashMap = new HashMap<String, Integer>();

        for (String nextWord: this.getWordArray()) {
            if (myHashMap.keySet().contains(nextWord)) {
                myHashMap.put(nextWord, myHashMap.get(nextWord) + 1);
            } else {
                myHashMap.put(nextWord, 1);
            }

        }

        return myHashMap;
    }
}