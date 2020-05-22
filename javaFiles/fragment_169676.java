public static void main(String[] args) throws Exception {
    List<String> lines = new ArrayList() {
        {
            add("abcd i");
            add("asd ffdds abcd ddd ?");
            add("abcd ffdds asd ddd i");
            add("ddd abcd i");
            add("a f g w e a asdfasdasdas fdd i");
            add("123 awef bad");
            add("123 awef bad");
            add("123 awef bad");
            add("oneword");
        }
    };

    Map<String, Integer> occurrences = new HashMap();
    for (String line : lines) {
        // Skip blank lines
        if (line.isEmpty()) {
            continue;
        }

        String[] words = line.split(" ");
        // Account for a line that might have only one word
        String nextToLastWord = words.length >= 2 ? words[words.length - 2] : words[0];
        occurrences.put(nextToLastWord,
                occurrences.get(nextToLastWord) == null
                        ? 1
                        : occurrences.get(nextToLastWord) + 1);
    }

    occurrences.entrySet().stream()
            // Sort the values in descending order
            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
            // Gets top 3 entries
            .limit(3)
            // Print them 
            .forEach(System.out::println);
}