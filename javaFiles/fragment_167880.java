public static String findParagraph(String source, String searchText, String paragraphSeparator)
{
    final int locationOfSearchTerm = source.indexOf(searchText);
    if (locationOfSearchTerm == -1) return null;

    int paragraphEnd = source.indexOf(paragraphSeparator, locationOfSearchTerm + searchText.length);

    //if we didn't find an end of a paragraph, we want to go the end
    if (paragraphEnd == -1) paragraphEnd = searchText.length;

    int paragraphStart = source.lastIndexOf(paragraphSeparator, locationOfSearchTerm);

    //if we didn't find a start of a paragraph, we want to go the beginning
    if (paragraphStart == -1) paragraphStart = 0;

    return searchText.subString(paragraphStart, paragraphEnd - 1);
}