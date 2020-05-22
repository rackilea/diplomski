private void findBadWords(List <String> wordList, List <String> auditList) {
    for(String badWord : auditList) {
        for (String word : wordList) {
            if (word.equals(badWord)) {
                System.err.println("Found a bad word");
            }
        }
    }
}