public static void main(String[] args) {
    String input = "YYYCZZZZGG";
    Map<Character, Integer> map = new HashMap<Character, Integer>(); // Map
    // to store character and its frequency.
    for (int i = 0; i < input.length(); i++) {
        Integer count = map.get(input.charAt(i)); // if not in map
        if (count == null)
            map.put(input.charAt(i), 1);
        else
            map.put(input.charAt(i), count + 1);
    }
    System.out.println(map);
}