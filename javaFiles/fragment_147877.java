public boolean checkContainsAll(String sentence, String[] words) {
    for(String word : words) {
        if(!sentence.contains(word)) {
            return false;
        }
    }
    return true;
}