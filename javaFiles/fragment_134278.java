protected String unescape(String str) {
    StringBuffer outBuffer = new StringBuffer(str.length());
    for (int index = 0; index < str.length();) {
        char c = str.charAt(index++);
        if (c == '\\') {
            c = str.charAt(index++);
            if (c == 't') {
                c = '\t';
            }
            else if (c == 'r') {
                c = '\r';
            }
            else if (c == 'n') {
                c = '\n';
            }
            else if (c == 'f') {
                c = '\f';
            }
        }
        outBuffer.append(c);
    }
    return outBuffer.toString();
}