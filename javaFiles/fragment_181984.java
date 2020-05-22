String text = "I like good mules. Mules are good :)";
String[] words = text.split("([\\W\\s]+)");
Map<String, Integer> counts = new HashMap<String, Integer>();
for (String word: words) {
    if (counts.containsKey(word)) {
        counts.put(word, counts.get(word) + 1);
    } else {
        counts.put(word, 1);
    }
}