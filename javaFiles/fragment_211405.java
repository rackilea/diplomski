TreeSet<String> originalSet = // as per question
List<String> mainWords = Arrays.asList("blue", "red");
Map<String, Set<String>> words = new HashMap<>();
for(String mainWord : mainWords) {
    words.put(mainWord, new HashSet<String>());
}
for(String line : originalSet) {
    String[] items = line.split(" ");
    if(words.keySet().contains(items[0])) {
        for(int i = 1 ; i < items.length ; i++) {
            words.get(items[0]).add(items[i]);
        }
    }
}