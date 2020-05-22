private String unescape(String searchTerm) {
    String specialChars = "+-&|!(){}[]^\"~:\\";
    for (char c : specialChars.toCharArray()) {
        String character = String.valueOf(c);
        String escaped = "\\" + character;
        searchTerm = searchTerm.replace(escaped, character);
    }
    return searchTerm;
}