static boolean characterSetsEqual(String text1, String text2) {
    Set<Character> set1 = toCharacterSet(text1);
    Set<Character> set2 = toCharacterSet(text2);
    return set1.equals(set2);
}

static Set<Character> toCharacterSet(String input) {
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < input.length(); i++) {
        set.add(input.charAt(i));
    }
    return set;
}