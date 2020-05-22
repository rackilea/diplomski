public void appendCentered(StringBuilder sb, String s, int width) {
    if (s.length() > width) {
        s = s.substring(0, width);
    }
    int spaces = width - s.length();
    int before = spaces / 2;
    int after = spaces - before; // Could be 1 more than 'before'.
    appendSpaces(sb, before);
    sb.append(s);
    appendSpaces(sb, after);
}

public void appendSpaces(StringBuilder sb, int width) {
    while (width-- > 0) {
        sb.append(' ');
    }
}