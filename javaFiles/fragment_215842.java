for (String word: words) {
    int value = 0;
    if  (occurrences.containsKey(word)) {
        value = occurrences.get(word);
    }
    occurrences.put(word, value + 1);
}

Map.Entry<String,Integer> tempResult = occurrences.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .findFirst().get();
JOptionPane.showMessageDialog(null, "Most Frequent Word: " + tempResult.getKey());