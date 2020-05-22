k = replace ( k, "<a target=\"_blank\" href=", "");


 String replace(String _text, String _searchStr, String _replacementStr) {
    // String buffer to store str
    StringBuffer sb = new StringBuffer();

    // Search for search
    int searchStringPos = _text.indexOf(_searchStr);
    int startPos = 0;
    int searchStringLength = _searchStr.length();
    // Iterate to add string
    while (searchStringPos != -1) {
        sb.append(_text.substring(startPos, searchStringPos)).append(_replacementStr);
        startPos = searchStringPos + searchStringLength;
        searchStringPos = _text.indexOf(_searchStr, startPos);
    }

    // Create string
    sb.append(_text.substring(startPos,_text.length()));

    return sb.toString();
}