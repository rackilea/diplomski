private String removeLines(List<Integer> removeLines, File text) throws IOException {
    StringBuilder builder = new StringBuilder();
    LineIterator it = FileUtils.lineIterator(text, StandardCharsets.UTF_8);

    try {
        for (int i = 1; it.hasNext(); i++) {
            String line = it.nextLine();

            if(!removeLines.contains(i)) {
                builder.append(line).append(System.lineSeparator());
            }
        }
    } finally {
        LineIterator.closeQuietly(it);
    }

    return builder.toString();   
}