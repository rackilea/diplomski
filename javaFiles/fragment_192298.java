public static String[] listWords(String sentence, String regex, String startSequence, String endSequence) {
    return Arrays.stream(sentence.split(regex))
            .filter(s -> s.startsWith(startSequence))
            .filter(s -> s.endsWith(endSequence))
            .collect(Collectors.toList()).toArray(new String[0]);
}