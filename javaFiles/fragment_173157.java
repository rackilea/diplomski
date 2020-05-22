for (String word : words) {
    word = word.toLowerCase(); // remove if you want case sensitivity
    if (occurences.containsKey(word)) {
        occurences.put(word, occurences.get(word) + 1);
    } else {
        occurences.put(word, 1);
    }
}