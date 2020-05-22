private void findBadWords(List <String> wordList, HashSet<String> auditWords) {
    for (String word : wordList) {
        if (auditWords.contains(word))) {
            System.err.println("Found a bad word");
        }
    }
}