boolean matches(String singleWord) {
    int from  = singleWord.indexOf('r');
    int to = singleWord.lastIndexOf('r');
    if (from < 0 || from == to) return false;
    String sub = singleWord.substring(from+1, to);
    return (sub.length() - sub.replaceAll("[aeiou]", "").length()) == 2;
}