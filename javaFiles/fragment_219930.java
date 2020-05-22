int startingIndexOfLastGroup(String str) {
    Pattern p = Pattern.compile(".*(?<!1)(1)");
    Matcher m = p.matcher(str);

    if (m.find()) {
        return m.start(1);
    }

    // Return -1 for a string without 1
    return -1;
}