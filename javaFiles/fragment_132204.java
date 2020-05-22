void parse(Reader r) throws IOException {
    BufferedReader br = new BufferedReader(r);

    // detect YAML front matter
    String line = br.readLine();
    while (line.isEmpty()) line = br.readLine();
    if (!line.matches("[-]{3,}")) { // use at least three dashes
        throw new IllegalArgumentException("No YAML Front Matter");
    }
    final String delimiter = line;

    // scan YAML front matter
    StringBuilder sb = new StringBuilder();
    line = br.readLine();
    while (!line.equals(delimiter)) {
        sb.append(line);
        sb.append("\n");
        line = br.readLine();
    }

    // parse data
    parseYamlFrontMatter(sb.toString());
    parseMarkdownOrWhatever(br);
}