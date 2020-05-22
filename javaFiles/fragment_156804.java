String word = "COUNTRY";
String sentence = "ASK NOT WHAT YOUR COUNTRY CAN DO FOR YOU ASK WHAT YOU CAN DO FOR YOU COUNTRY";

if (sentence.contains(word)) {
    String[] sentenceWords = sentence.split(" ");

    for (int i = 0; i < sentenceWords.length; i++) {
        if (sentenceWords[i].equals(word)) {
            System.out.println(word + " is located as the: " + i + "th string");
        }
    }
}