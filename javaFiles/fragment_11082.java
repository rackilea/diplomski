static Pattern pattern = Pattern.compile("\\d+");
String convert(String input) {
    StringBuffer output = new StringBuffer();
    Matcher matcher = pattern.matcher(input);
    while (matcher.find()) {
        String rep =
            String.format("%d %s POSINT_TAG",
                          matcher.group().length(),
                          matcher.group());
        matcher.appendReplacement(output, rep);
    }
    matcher.appendTail(output);
    return output.toString();
}