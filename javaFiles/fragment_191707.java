String s[]={"cat","cat","dog","fox","cat","fox","dog","cat","fox"};

Map<String, Integer> counts = new HashMap<String, Integer>();
for (String word : s) {
    if (!counts.containsKey(word))
        counts.put(word, 0);
    counts.put(word, counts.get(word) + 1);
}