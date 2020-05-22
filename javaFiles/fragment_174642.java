String[] words = string.toLowerCase().split("\\s+");
Map<String, Integer> wordCounts = new HashMap<String, Integer>();

for (String word : words) {
    Integer count = wordCounts.get(word);
    if (count == null) {
        count = 0;
    }
    wordCounts.put(word, count + 1);
}