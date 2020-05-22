public int countMatches(List<String> comments) {
    int numberOfMatches = 0;
    for (String comment : comments) {
        if (comment.matches(".*\\bjoe\\b.*")) {
            numberOfMatches++;
        }
    }
    return numberOfMatches;
}