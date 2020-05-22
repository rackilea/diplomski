List<List<String>> sentences = new ArrayList<List<String>>();
while (haveMoreData(myFile)) {
    List<String> words = new ArrayList<String>();
    readNextSentence(myFile, words);
    sentences.add(words);
}