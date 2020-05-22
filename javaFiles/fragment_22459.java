static String blow(String s) {
    String vowels = "aeiouAEIOU";
    String middle = s.replaceAll("[" + vowels + "]", " ");
    int flip = 0;
    String[] side = { "", "" };
    Scanner sc = new Scanner(s);
    for (String word; (word = sc.findInLine("\\s*\\S*")) != null; ) {
        side[flip] += word.replaceAll(".", " ");
        side[1-flip] += word.replaceAll("[^" + vowels + "]", " ");
        flip = 1-flip;
    }
    return String.format("|%s|%n|%s|%n|%s|", side[0], middle, side[1]);
}