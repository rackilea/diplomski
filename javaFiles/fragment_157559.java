class PositionableCharArray {
    int pos;
    char[] chars;

    ...
    public void setPos(int pos) { ... }
    public char readChar() { return chars[pos++]; }
}