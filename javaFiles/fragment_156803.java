String word = "COUNTRY";
String sentence = "ASK NOT WHAT YOUR COUNTRY CAN DO FOR YOU ASK WHAT YOU CAN DO FOR YOU COUNTRY";

if (sentence.contains(word)) {
    String[] sentenceWords = sentence.split(" ");

    for (String wordInSentence : sentenceWords) {
        if (wordInSentence.equals(word)) {
            System.out.println(wordInSentence);
        }
    }
}