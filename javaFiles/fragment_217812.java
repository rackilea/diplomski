private String method(String input) {
    Map<Character, Integer> integerMap = new HashMap<>();
    for(char c: input.toCharArray()) {
        integerMap.merge(c, 1, Integer::sum);
    }

    StringBuilder sb = new StringBuilder();
    for(Map.Entry<Character, Integer> e : integerMap.entrySet()) {
        sb.append(e.getKey()).append(e.getValue());
    }
    return sb.toString();
}