for (Synset synset : synsetsNoun) {
    // Fetch the elements to add
    ArrayList<String> elementsToAdd = WordNetSynset.getWordFormsOf(synset);

    // Add the elements to the list
    wordForms.addAll(elementsToAdd);
}

// Print the contents
System.out.println("\ts: " + wordForms);