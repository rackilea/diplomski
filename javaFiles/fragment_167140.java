public static void main(String[] args) throws Exception {
    final Pattern pattern = Pattern.compile("(\\D{4})(\\d{9})(\\D{4})");
    final String input = "ABCD000000001XYZL";
    final Matcher matcher = pattern.matcher(input);
    if (matcher.matches()) {
        final String head = matcher.group(1);
        final long number = Long.parseLong(matcher.group(2)) + 1;
        final String tail = matcher.group(3);
        final String result = String.format("%s%09d%s", head, number, tail);
        System.out.println(result);
    }
}