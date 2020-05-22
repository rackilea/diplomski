ArrayList<ArrayList<WordText>> Sentences = new ArrayList<ArrayList<WordText>>;
ArrayList<WordText> currentSentence = new ArrayList<WordText>;
Document document = new Document();

// Build sentences
for (int pageNumber = 0, max = document.getNumberOfPages(); 
     pageNumber < max;     pageNumber++) {
  PageText pageText = document.getPageText(pageNumber);
  ArrayList<LineText> pageLines = pageText.getPageLines();
  for (LineText pageLine : pageLines) {
    ArrayList<WordText> words = pageLine.getWords();
    for (WordText word : words) {
      // If this is a word, and the last word was not a space, 
      // start a new sentence
      if(!word.getText().equals(" ") && currentSentence.size() > 0
         !currentSentence.get(currentSentence.size() - 1).getText().equals(" ")) {
        sentences.add(currentSentence);
        currentSentence = new ArrayList<WordText>;
      }
      // Add word to current sentnece
      currentSentence.add(word);
    }
   // Add the last sentence in
   sentences.add(currentSentence);
  }
}