for(String word : wordArray) {
    Integer count = wordMap.get(word);
    if(count == null) {           // first time for "word" => insert 1
        wordMap.put(word, 1);
    } else {                      // else increment the count
        wordMap.put(word, count + 1);
    }
}