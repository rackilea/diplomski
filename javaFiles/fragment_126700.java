List<String> words = readWordsFromFile();

Map<String, Integer> wordCounts = new HashMap<>();
for(String word : words) {
    String processedWord = preprocess(word);
    int count = 1;
    if (wordCounts.containsKey(processedWord)) {
        count = wordCounts.get(processedWord)+1;
    }
    wordCounts.put(processedWord, count);
}

removeSingleOccurences(wordCounts); 
List<String> sortedWords = sortWords(wordCounts);