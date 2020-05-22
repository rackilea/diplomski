public ArrayList getWords(String searchWord, String listOfWords){
    ArrayList<String> foundWords = new ArrayList<>();
    if (listOfWords.contains(searchWord)){
        foundWords.add(searchWord);
    }
return foundWords;
}