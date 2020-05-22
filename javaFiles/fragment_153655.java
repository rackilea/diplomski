Map<String, Integer> words = HashMap<String, Integer>();
for (String word : words) {
    Integer count = words.get(word);
    count = count == null ? 0 : count++;
    words.put(word, count);
}