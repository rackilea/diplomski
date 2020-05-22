public static void main(String[] args) {
    final Pattern pattern = Pattern.compile("B[aAc-zC-Z0-9]{0,6}");
    final String string = " abcdB1234B123456";
    final Matcher matcher = pattern.matcher(string);
    while (matcher.find()) {
        System.out.println(matcher.group());
    }
}