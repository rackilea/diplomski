private String[] getCharArray(String unicodeStr) {
    ArrayList<String> list = new ArrayList<>();
    int i = 0, j;
    while (i < unicodeStr.length()) {
        j = unicodeStr.offsetByCodePoints(i, 1);
        list.add(unicodeStr.substring(i, j));
        i = j;
    }
    return list.toArray(new String[list.size()]);
}