public static void main(String[] args) throws Exception {
    final Pattern pattern = Pattern.compile("(?<=\\D{4})(\\d{9})(?=\\D{4})");
    final String input = "ABCD000000001XYZL";
    final Matcher matcher = pattern.matcher(input);
    final StringBuffer result = new StringBuffer();
    if (matcher.find()) {
        final long number = Long.parseLong(matcher.group(1)) + 1;
        matcher.appendReplacement(result, String.format("%09d", number));
    }
    matcher.appendTail(result);
    System.out.println(result);
}