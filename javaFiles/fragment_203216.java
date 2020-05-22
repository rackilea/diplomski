ArrayList<String> words = new ArrayList<>();
words.add("Cat");
words.add("Dog");
words.add("Bird");
words.add("Dog");
words.add("Cat");
words.add("Dog");

HashMap<String, Integer> counters = new HashMap<>();
for (String word : words) {
    if (counters.containsKey(word)) {
        counters.put(word, counters.get(word) + 1);
    } else {
        counters.put(word, 1);
    }
}

System.out.print(counters);