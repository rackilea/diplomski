private int peekPastWhitespace(int ch) {
    while (ASCII.isSpace(ch) || ch == '#') {
        while (ASCII.isSpace(ch))
            ch = temp[++cursor]
        if (ch == '#') {
            ch = peekPastLine();
        }
    }
    return ch;
}