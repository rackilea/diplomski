static String X(String sentence, String... args) {
   for (String arg : args) {
        sentence = sentence.replaceFirst("\\?", arg);
    }
    return sentence;
}