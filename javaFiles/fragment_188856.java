Map<String, Integer> counts = new HashMap<String, Integer>();
    for (String word : words) {
    Integer count = counts.get(word);
    if (count == null) {
        counts.put(word, 1);
    } else {
       counts.put(word, count + 1);
    }
}