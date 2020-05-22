private void checkAmbiguousWord(){
    final String textToCheck = text.getText().toString();
    List<Integer> ambiguousIndexes = findAmbiguousWordIndexes(textToCheck);
    view.setText(!ambiguousIndexes.isEmpty() ? ambigousIndexesToMessage(ambiguousIndexes) : "No ambiguous word/s found.");
}

    public String ambigousIndexesToMessage(List<Integer> ambiguousIndexes) {
        // create the text using the indexes
        // this is an example implementation
        return ambiguousIndexes.toString(); // creates a list of "1","2",...
    }

/**
 * @param text checked for ambguous words
 * @return the list of indexes of the the ambiguous words in the {@code words} array          
 */
private List<Integer> findAmbiguousWordIndexes(String text) {
    final String lowerCasedText = text.toLowerCase();
    final List<Integer> ambiguousWordIndexList = new ArrayList<Integer>();
    for (int i = 0; i < words.length; i++) {
        if (lowerCasedText.contains(words[i].toLowerCase())) {
            ambiguousWordIndexList.add(i);
        }
    }
    return ambiguousWordIndexList;
}