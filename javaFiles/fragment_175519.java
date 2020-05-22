while (s.hasNext()) {
    String word = s.next();
    for(int i = 0; i < array.length; i++) {
        if (word.equals(array[i])) {
            wordCount[i]++;
        }
    }
}