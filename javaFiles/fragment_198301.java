public String stripNonValidXMLCharacters(String in) {
    StringBuffer out = new StringBuffer(); // Used to hold the output.
    char current; // Used to reference the current character.

    if (in == null || ("".equals(in))) return ""; // vacancy test.
    for (int i = 0; i < in.length(); i++) {
        current = in.charAt(i);
        if ((current == 0x9) ||
            (current == 0xA) ||
            (current == 0xD) ||
            ((current >= 0x20) && (current <= 0xD7FF)) ||
            ((current >= 0xE000) && (current <= 0xFFFD)) ||
            ((current >= 0x10000) && (current <= 0x10FFFF)))
            out.append(current);
    }
    return out.toString();
}