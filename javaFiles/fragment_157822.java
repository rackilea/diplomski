public String addPadding(int length, String text) {
    StringBuilder sb = new StringBuilder();

    // First, add (length - 'length of text') number of '0'
    for (int i = length - text.length(); i > 0; i--) {
        sb.append('0');
    }

    // Next, add string itself
    sb.append(text);
    return sb.toString();
}