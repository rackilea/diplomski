String input = "Whatever";
Map<Character, Integer> charCounter = new LinkedHashMap<>(); // respects insertion order
for (char c : input.replaceAll("\\s+", "").toCharArray()) { // ignore spaces
    Integer count = charCounter.get(c);
    count = count == null ? 0 : count;
    charCounter.put(c, count + 1);
}
System.out.println(charCounter);