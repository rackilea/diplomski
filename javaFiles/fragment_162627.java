public String[] parseMyStrings(String s) {
    int beginIndex = s.indexOf("[") + 1;
    int endIndex = s.indexOf("]");

    s = s.substring(beginIndex, endIndex);

    // split and trim in one shot
    return s.split(("\\s*,\\s*"));
}