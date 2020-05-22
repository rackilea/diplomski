private String processBackspace(String input) {
    StringBuilder sb = new StringBuilder();
    for (char c : input.toCharArray()) {
        if (c == '\b') {
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        } else {
            sb.append(c);
        }
    }
    return sb.toString();
}