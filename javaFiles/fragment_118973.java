public static List<List<String>> linesToLinesAndWords(String lines) {
    List<List<String>> wordlists = new ArrayList<>();
    List<String> lineList = Arrays.asList(lines.split("\n"));
    for (String line : lineList) {
        wordlists.add(Arrays.asList(line.trim().split(" ")));
    }
    return wordlists;
}