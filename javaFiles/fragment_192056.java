String replaceSpace(String string) {
    StringBuilder sb = new StringBuilder();
    for(char c : string.toCharArray()) {
        if (c == ' ') {
            sb.append("%20");
        } else {
            sb.append(c);
        }
    }
    return sb.toString();
}