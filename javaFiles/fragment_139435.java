ok.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        checkAmbiguousWord();
    }   
});  

...

private void checkAmbiguousWord(){
    final String textToCheck = text.getText().toString();
    Integer ambiguousIndex = findAmbiguousWordIndex(textToCheck);
    view.setText(ambiguousIndex != null ? meanings[ambiguousIndex] : "No ambiguous word/s found.");
}

/**
 * @param text checked for ambguous words
 * @return the index of the ambiguous word in the {@code words} array or
 * null if no ambiguous word is found
 */
private Integer findAmbiguousWordIndex(String text) {
    final String lowerCasedText = text.toLowerCase();
    for (int i = 0; i < words.length; i++) {
        if (lowerCasedText.contains(words[i].toLowerCase())) {
            return i;
        }
    }
    return null;
}