// Using loops
public static Set<String> distinctWords(String... input) {
    Set<String> distinct = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
    for (String s : input)
        for (String word : s.trim().split("\\s+"))
            distinct.add(word);
    return distinct;
}