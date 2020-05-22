private boolean containsOneAndOnlyOne(String s, char c) {
    int firstIndex = s.indexOf(c);
    if (firstIndex < 0) {
        return false;
    }
    int secondIndex = s.indexOf(c, firstIndex + 1);
    return secondIndex < 0;
}