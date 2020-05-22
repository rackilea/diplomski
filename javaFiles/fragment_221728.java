Pattern pat = Pattern.compile("((?:[^\u0003]*\u0003){30}[^\u0003]*)\u0003(.*)");
Matcher matcher = pat.matcher(input);
if (matcher.matches()) {
    String leftPart = matcher.group(1);
    String rightPart = matcher.group(2);
}