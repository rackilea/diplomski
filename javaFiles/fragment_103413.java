Path path = Paths.get("C:/Users/Me/list.txt");
//Charset encoding = StandardCharsets.UTF_8;
Charset encoding = Charset.defaultCharset();
List<String> lines = Files.readAllLines(path, encoding);

for (String line : lines) {
    ...
}

for (int i = 0; i < lines.size(); ++i) {
     String line = lines.get(i);
     lines.set(i, "-- " + line;
}