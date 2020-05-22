Path fileInOut = Paths.get("fruits.in");
Charset defaultCharset = Charset.defaultCharset();
List<String> linesIn = Files.readAllLines(fileInOut, defaultCharset);
List<String> linesOut = new ArrayList<>();
for (String line : linesIn) {
    if (line.isEmpty()) {
        linesOut.add("orange");
        linesOut.add("melon");
    }
    linesOut.add(line);
}
linesOut.add("orange");
linesOut.add("melon");
Files.write(fileInOut, linesOut, defaultCharset, StandardOpenOption.TRUNCATE_EXISTING);