private StringBuilder convertToString(InputStream inputStream) throws IOException {
    StringBuilder textBuilder = new StringBuilder();
    try (Reader reader = new BufferedReader(
            new InputStreamReader(inputStream, Charset.forName(StandardCharsets.UTF_8.name())))) {
        int c = 0;
        while ((c = reader.read()) != -1) {
            textBuilder.append((char) c);
        }
    }
    return textBuilder;
}