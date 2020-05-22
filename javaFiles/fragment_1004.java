public List<Word> getAllWords(List<Lemma> key) {
    List<Word> returnValue = new ArrayList<>();
    for(List<Word> list : map.get(key).values()) {
        returnValue.addAll(list);
    }
    return returnValue;
}