if (wordMap.containsKey(letter)) {
    Integer prev = wordMap.get(letter);
    wordMap.put(letter, prev++);
}  else {
    wordMap.put(letter, 1);
}