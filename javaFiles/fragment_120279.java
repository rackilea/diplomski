List<String> wordForms = synsetsNoun.stream()           // Synsets
    .map(WordNetSynset::getWordFormsOf)                 // Lists of wordForms
    .flatMap(Collection::stream)                        // WordForms
    .collect(Collectors.toCollection(ArrayList::new));  // Collect to ArrayList

// Print the contents
System.out.println("\ts: " + wordForms);