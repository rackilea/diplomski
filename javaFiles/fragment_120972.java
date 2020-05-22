public class WordGroup {

    String  word;
    HashMap<String, Integer> myHashMap = new HashMap<String, Integer>();

    // Creates constructor which stores a string value in variable "word" and converts this into lower case using
    // the lower case method.
    public WordGroup(String aString) {

        this.word = aString.toLowerCase();
        this.createWordCountsMap();
    }

    public String[] getWordArray() {

        String[] wordArray = word.split("-");
        return wordArray;
    }

    public HashMap<String, Integer> getWordCountsMap()
    {
        return this.myHashMap;
    }

    private void createWordCountsMap() {

        for (String nextWord : this.getWordArray()) {
            if (this.myHashMap.keySet().contains(nextWord)) {
                this.myHashMap.put(nextWord, this.myHashMap.get(nextWord) + 1);
            } else {
                this.myHashMap.put(nextWord, 1);
            }
        }
    }
}