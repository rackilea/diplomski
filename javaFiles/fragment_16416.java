public ArrayList<String> findStrings(ArrayList<String> searchStrings) {
    ArrayList<String> foundStrings = new ArrayList<>();
    while (hasMoreLines()) {
        String content = getNextString();
        if (countStrings(content, searchStrings) == 2) {
            foundStrings.add(content);
        }
    }
    return foundStrings;
}

private int countStrings(String content, ArrayList<String> searchStrings) {
    int count = 0;
    for (String searchString : searchStrings) {
        if (content.contains(searchString)) {
            count++;
        }
    }
    return count;
}