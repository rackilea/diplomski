public String toString() {
    String results = "";
    for (String words : lowercaseArray) {
        results += " " + words + " ";
    }
    return results;
}