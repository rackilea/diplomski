String[] parts = data.split("\\*");
Pattern pattern = Pattern.compile(
    Stream.of(parts).map(Pattern::quote).collect(Collectors.joining(".*")));
Matcher matcher = pattern.matcher("");

for (File file : files) {
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        String text;
        while ((text = reader.readLine()) != null) {
            if (matcher.reset(text).find()) {
                return text;
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}