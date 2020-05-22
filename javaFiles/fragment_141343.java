Map<Integer, Set<String>> sMap = new TreeMap<>();
for (Map.Entry<String, Integer> entry : dMap.entrySet()) {
    Integer appearances = entry.getValue();
    Set<String> words = sMap.get(appearances);
    if (words == null) {
        words = new HashSet<>();
        sMap.put(appearances, words);
    }
    words.add(entry.getKey());
}