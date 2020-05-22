public static void main(String[] args) {
    Pattern pattern = Pattern.compile("(p|q|r|v|\\^|~|=>|<=>)");
    Matcher matcher = pattern.matcher(yourString);
    while (matcher.find()) {
        System.out.println(matcher.group());
    }
}