List<List<String>> sentences = new ArrayList<List<String>>();
List<String> words = new ArrayList<String>();
// This is broken!
while (haveMoreData(myFile)) {
    readNextSentence(myFile, words);
    sentences.add(words);
    words.clear();
}