public <T> Map<String, T> subMapWithKeysThatAreSuffixes(String prefix, NavigableMap<String, T> map) {
    if ("".equals(prefix)) return map;
    String lastKey = createLexicographicallyNextStringOfTheSameLenght(prefix);
    return map.subMap(prefix, true, lastKey, false);
}

String createLexicographicallyNextStringOfTheSameLenght(String input) {
    final int lastCharPosition = input.length()-1;
    String inputWithoutLastChar = input.substring(0, lastCharPosition);
    char lastChar = input.charAt(lastCharPosition) ;
    char incrementedLastChar = (char) (lastChar + 1);
    return inputWithoutLastChar+incrementedLastChar;
}