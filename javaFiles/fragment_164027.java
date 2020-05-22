public boolean foundPattern( Document doc, int pos, int findLength  ) {
    String match = doc.getText(pos, findLength).toLowerCase();
    // Check to see if it matches or request
    if (match.equals(patteren)) {
        if (pos - 1 >= 0
                    && Character.isWhitespace(doc.getText(pos - 1, 1).charAt(0))
                                    || Character.isWhitespace(doc.getText(findLength, 1).charAt(0))) {
            if (pos + findLength == doc.getLength()
                                         || Character.isWhitespace(doc.getText(pos + findLength, 1).charAt(0))) {
                return true;
            }
        }
    }
    return false;
}