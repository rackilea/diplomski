public static void main(String[] args) {
    final String regex = ".+?(?=0|1)";
    final String string = "this is a test 1";

    final Pattern pattern = Pattern.compile(regex);
    final Matcher matcher = pattern.matcher(string);

    if (matcher.find()) {
        System.out.println(matcher.group(0));
    }
}