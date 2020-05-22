public static void main(String[] args) {
    final String strWords = "The color of the car is blue.";
    final String word1 = "color";
    final String word2 = "blue";

    // Remove any special chars from string
    final String strOnlyWords = strWords.replace(",", "").replace(".", "");

    final List<String> words = Arrays.asList(strOnlyWords.split(" "));
    final int index1 = words.indexOf(word1);
    final int index2 = words.indexOf(word2);
    int distance = -1;

    // Check index of two words
    if (index1 != -1 && index2 != - 1) {
        distance = index2 - index1;
    }

    System.out.println(distance);
}