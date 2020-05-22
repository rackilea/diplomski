private static int countOccurencesOf(final String countMatchesOf, final File inFile) throws IOException {
    final Pattern pattern = Pattern.compile("\\b" + countMatchesOf + "\\b");
    int count = 0;
    try (final BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(new FileInputStream(inFile), "UTF-8"))) {
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            final Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                ++count;
            }
        };
    }
    return count;
}