public Lexicon(String filename) throws IOException{
....

    public void addWord(Scanner scanWord, List<> wordLst) {
        if (scanWord.hasNextLine()) {
            wordLst.add(scanWord.nextLine());
            addWord(scanWord, wordLst);
        } else {
            // base case - no more words
        }
    }
...
}