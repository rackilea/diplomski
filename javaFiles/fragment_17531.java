public ArrayList<String> getAnagrams(String word, ArrayList<String> dictionary) {
    if(word == null || dictionary == null) {
        return null;
    }

    ArrayList<String> anagrams = new ArrayList<String>();
    char[] sortedChars = word.toCharArray();
    Arrays.sort(sortedChars);
    for(String item : dictionary) {
        char[] sortedDictionaryItem = item.toCharArray();
        Arrays.sort(sortedDictionaryItem);
        if(Arrays.equals(sortedChars, sortedDictionaryItem)) {
            anagrams.add(item);
        }
    }
    return anagrams;
}