public static void main(String[] args) {
    String headerColumn = "  A        B     C     D         E";
    String firstLine = " 1        2                     3";
    String secondLine = " 4              6     7    ";

    Map<Integer, String> indexHeaderMap = new HashMap<Integer, String>();
    // Get header indexes
    for (int i = 0; i < headerColumn.length(); i++) {
        String currChar = String.valueOf(headerColumn.charAt(i));
        if (!currChar.equals(" ")) {
            indexHeaderMap.put(i, currChar);
        }
    }

    // Parse first line
    parseLine(firstLine, indexHeaderMap);
    // Parse second line
    parseLine(secondLine, indexHeaderMap);
}