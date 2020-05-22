private static List<String> makeFilterKeywords(String keyword) {
    List<String> filteringKeywords = new ArrayList<String>();
    filteringKeywords.add(keyword);
    return filteringKeywords;
}
public KeywordFilter(String keyword) {
    this(makeFilterKeywords(keyword));
}