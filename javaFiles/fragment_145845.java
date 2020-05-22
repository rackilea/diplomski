private String removeLines(List<Integer> removeLines, File text) throws IOException {
    List<String> textLines = FileUtils.readLines(text, StandardCharsets.UTF_8);

    for(Integer removeLine : removeLines) {
        textLines.remove(removeLine - 1); // -1, depending on how you specify removeLines
    }

    StringBuilder builder = new StringBuilder();

    for(String line : textLines) {
        builder.append(line).append(System.lineSeparator());
    }

    return builder.toString();   
}