for (int i = 0; i < s.length() - 1; i++) {
    if (!Character.isWhitespace(s.charAt(i))) {
        buf.append(s.charAt(i));
    } else if (Character.isWhitespace(s.charAt(i)) &&   !Character.isWhitespace(s.charAt(i + 1))) {
        buf.append(s.charAt(i));
    }
}