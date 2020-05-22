Integer prev = wordMap.get(letter);
if (prev == null) {
    wordMap.put(letter, 1);
}  else {
    wordMap.put(letter, prev++);
}