public Map<String, Integer> countWords(List<String> words) {
    Map<String, Integer> result = new Map<>();
    for (String word : words) {
        if (result.containsKey(word)) {
            // the word is already in the map, increment the count
            int count = result.get(word) + 1;
            result.put(word, count);
        } else {
            result.put(word, 1);
        }
    }

    return result;
}