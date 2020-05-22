/**
 * Tells if every prefix has a corresponding word and if every word, lower-cased, 
 * starts with the corresponding prefix.
 */
private boolean allPrefixesMatch(String[] prefixes, String[] words) {
    if (words.length < prefixes.length) {
        return false;
    }
    for (int i = 0; i < prefixes.length; i++) {
        String prefix = prefixes[i];
        String word = words[i];
        if (!word.toLowerCase().startsWith(prefix)) {
            return false;
        }
    }
    return true;
}