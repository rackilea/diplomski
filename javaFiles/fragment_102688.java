public static String scramble(String input) {
    int range = input.length() - 3;
    int place = (int)(Math.random() * range);
    String newWord = input.substring(0, place);
    newWord = newWord + input.charAt(place + 1);
    newWord = newWord + input.charAt(place);
    // if you need the whole input, just 2 characters exchanged, uncomment this next line
    // newWord = newWord + input.substring(place + 2, range);
    return newWord;
}