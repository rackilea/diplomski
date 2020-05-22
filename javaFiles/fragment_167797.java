Pattern regex = Pattern.compile("(\\d+)(\\D{1,2})(\\d+)(\\D{1,2})(\\d+)(\\D{1,2})");
Matcher matcher = regex.matcher("16B66C116B");

while (matcher.find()) {
    for (int i = 1; i <= matcher.groupCount(); ++i) {
        System.out.println(matcher.group(i));
    }
}