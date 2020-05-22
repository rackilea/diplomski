String textarray[] = text.split(" ");

// TreeMap gives sorting by alphabetical order "for free"
Map<String, Integer> wordCounts = new TreeMap<>();

for (int i = 0; i < textarray.length; i++) {
    Integer count = wordCounts.get(textarray[i]);
    wordCounts.put(textarray[i], count != null ? count + 1 : 1);
}

for (Map.Entry<String, Integer> e : wordCounts.entrySet()) {
    System.out.println("<" + e.getKey() + "> - <" + e.getValue() + ">");
}