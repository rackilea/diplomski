Map<String, Set<Integer>> index = new TreeMap<>();
int currentPage = -1;
String currentLine;
while ((currentLine = reader.readLine()) != null) {
    if (isPage(currentLine)) {
        currentPage = getPageNum(currentLine);
    } else {
        assert currentPage > 0;
        for (String word: words(currentLine)) {
            if (!index.contains(word))
                index.put(word, new TreeSet<>());
            index.get(word).add(currentPage);
        }
    }
}