private static List<String> extractFirstLevelNew(String type) {
    List<String> res = new LinkedList<String>();
    int start = 0;
    int nesting = 0;
    for (int i = 0; i < type.length(); i++) {
        char chr = type.charAt(i);
        if (chr == '<') {
            nesting++;
        } else if (chr == '>') {
            nesting--;
        } else if ((chr == ',') && (nesting == 0)) {
            res.add(type.substring(start, i).trim());
            start = i + 1;
        }
    }
    res.add(type.substring(start, type.length()).trim());
    return res;
}