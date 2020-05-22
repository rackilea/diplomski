public static void printNonAscii(String s) {
    TreeSet<Character> nonAscii = new TreeSet<>();
    for (char ch : s.replaceAll("[\r\n\\x20-\\x7E]", "").toCharArray())
        nonAscii.add(ch);
    for (char ch : nonAscii)
        System.out.printf("\\u%04X  %s%n", (int) ch, ch);
}