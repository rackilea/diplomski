public String deleteAllExceptFirst(String input, String needle) {
    if (input.contains(needle)) {
        return needle;
    } else {
        return "";
    }
}