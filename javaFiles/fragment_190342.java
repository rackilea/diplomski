static void printDistinct(String str) {
    Set<Character> origSet = new LinkedHashSet<Character>();
    StringBuilder concat = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
        if (origSet.add(str.charAt(i))) {
            concat.append(str.charAt(i));
        }
    }
    System.out.println(concat);
}