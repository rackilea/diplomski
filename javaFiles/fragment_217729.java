String s = ...;
HashMap<Character, Integer> charCount = new HashMap<>();
for (char c : s.toCharArray()) {
    Integer count = charCount.get(c);
    if (count == null) count = 0;
    map.put(c, ++count);
}