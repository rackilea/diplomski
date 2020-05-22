public static List<String> justifyLines(String input, int lineLength) {
    String[] words = input.split(" ");
    List<String> result = new ArrayList<>();
    StringBuilder line = new StringBuilder();
    //here we store positions of all spaces in the current line to add more spaces there
    List<Integer> spacesPositions = new ArrayList<>();
    for (String word : words) {
        if (word.length() <= lineLength - line.length()) {
            line.append(word).append(" ");
            spacesPositions.add(line.length() - 1);
        } else {
            result.add(justifyLine(line, lineLength, spacesPositions));
            line.setLength(0);
            spacesPositions.clear();
            line.append(word).append(" ");
            spacesPositions.add(line.length() - 1);
        }
    }
    if (line.length() > 0) {
        result.add(justifyLine(line, lineLength, spacesPositions));
    }
    return result;
}

private static String justifyLine(StringBuilder line, int lineLength, List<Integer> spacesPositions) {
    //if line ends with space - remove it
    if (line.lastIndexOf(" ") == line.length() - 1) line.setLength(line.length() - 1);
    int spacesToAdd = lineLength - line.length();
    for (int j = 0; j < spacesToAdd; j++) {
        //It's the most complicated part, but I'll try to explain
        line.insert(
                // We're adding one space to each space in the line and then, if there are still spaces to insert,
                // repeating this process from the beginning - that's why we're using %
                spacesPositions.get(j % (spacesPositions.size() - 1))
                        // But each time we insert a new space, we need to take it into account for the following positions
                        // j % (spacesPositions.size() - 1) is the number of space in the line
                        // j / (spacesPositions.size() - 1) + 1 is the iteration number
                        + j % (spacesPositions.size() - 1) * (j / (spacesPositions.size() - 1) + 1), " ");
    }
    return line.toString();
}