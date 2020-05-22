public static void main(String[] args) {
    String sentence = "Hello alan i am here where are you and what are you doing hello are you there";
    List<String> words = Arrays.asList(sentence.split(" "));

    List<String> result = 
            words.stream()
                 .map(String::toLowerCase)
                 .collect(groupingBy(identity(), counting()))
                 .entrySet().stream()
                 .sorted(Map.Entry.<String, Long> comparingByValue(reverseOrder()).thenComparing(Map.Entry.comparingByKey()))
                 .limit(7)
                 .map(Map.Entry::getKey)
                 .collect(toList());

    System.out.println(result);
}