private void findAmbiguousWord(){
String string = text.getText().toString();
// create a set to store the results
Set<String> result = new HashSet<String>();
for (int i = 0; i < words.length; i++) {
    if (string.toLowerCase().contains(words[i].toLowerCase())) {
        // ambiguous word, we need its meaning!
        result.add(meanings[i]);
    } 
}

// display the results if there are some
view.setText(result.isEmpty() ? "No ambiguous word/s found." : result.toString());
}