Path path = Paths.get(System.getProperty("user.dir"), "htmlTemplate", lang, page + ".html");
try (BufferedReader br = Files.newBufferedReader(path)) {
    StringBuilder website = new StringBuilder();
    String currentLine;
    while ((currentLine = br.readLine()) != null) {
        website.append(currentLine);
    }
    return website.toString();
}