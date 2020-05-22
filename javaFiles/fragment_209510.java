private String translate(String word) {
    Matcher match = Pattern.compile("(\\w*)([aeiou]\\w*)").match(word);
    if (match.matches())
        return match.group(2) + match.group(1) + "ay";
    else
        return word;
}