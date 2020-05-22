public String[] split(String text) {
    if (text == null) {
        text = "";
    }

    int last_match = 0;
    LinkedList<String> splitted = new LinkedList<String>();

    Matcher m = this.pattern.matcher(text);

    // Iterate trough each match
    while (m.find()) {
        // Text since last match
        splitted.add(text.substring(last_match,m.start()));

        // The delimiter itself
        if (this.keep_delimiters) {
            splitted.add(m.group());
        }

        last_match = m.end();
    }
    // Trailing text
    splitted.add(text.substring(last_match));

    return splitted.toArray(new String[splitted.size()]);
}