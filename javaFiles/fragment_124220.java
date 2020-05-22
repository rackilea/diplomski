static void PrintWords(Sentence<? extends Sentence> words) {
    for(String word : words) {
        System.out.println(new StringBuilder(word).append(": ").append(word.length())
                .toString());
    }
}