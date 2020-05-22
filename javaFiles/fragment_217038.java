Map<Character, Integer> map = new HashMap<>();
for(char c: word1.toCharArray()) {
    map.put(c, 0);
}
for(char c: word2.toCharArray()) {
    Integer count = map.get(c);
    if(count != null) {
        count++;
        map.put(c, count);
    }
}
for(Map.Entry<Character, Integer> entry: map.entrySet()) {
    System.out.println(entry.getKey() + " " + entry.getValue() + " times");
}