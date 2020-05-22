List<String> lines = Files.readAllLines(path, Charset.defaultCharset());

// Result:
List<List<String>> lists = new ArrayList<>();

List<String> newList = null;
boolean addNewList = true;
for (int i = 0; i < lines.size(); ++i) {
    if (addNewList) {
        newList = new ArrayList<>();
        lists.add(newList);
        addNewList = false;
    }
    String line = lines.get(i);
    if (line.endsWith(",")) {
        line = line.substring(0, line.length() - 1);
        addNewList = true;
    }
    newList.add(line);
}