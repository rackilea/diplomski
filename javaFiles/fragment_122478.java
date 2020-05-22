private boolean anyWordStartsWith(final String words, final String search) {
    for (final String word : words.split("\\s*,\\s*")) {
        if(word.startsWith(search)) return true;
    }
    return false;
}