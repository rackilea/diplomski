public static String specialStrings(String s) {
    Matcher matcher = specialStringPattern.matcher(s);
    boolean findAgain = false;
    while (matcher.find()) {
        String text = matcher.group();
        text = text.replace("@","").replaceAll("\"","");
        s = s.replace(matcher.group(),map.get(text));
        findAgain = true;
    }
    if (findAgain) return specialStrings(s);
    return s;
}