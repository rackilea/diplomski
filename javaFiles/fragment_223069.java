public static String wordEnds(String input, String word) {
    word = Pattern.quote(word); // add this line to be 100% safe
    return input.replaceAll(".*?(.)" + word + "(?:(?=(.)" + word + ")|(.).*?(?=$|." + word + "))", "$1$2$3");
}

public static void main(String[] args) {
    System.out.println(wordEnds("abcXY123XYijk", "XY"));
    System.out.println(wordEnds("abc1xyz1i1j", "1"));
}