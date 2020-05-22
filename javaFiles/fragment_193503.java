public static void main(String[] args) throws Exception {
    final String[] values = {"DBValue0", "DBValue1", "DBValue2", "DBValue3", "DBValue4", "DBValue5", "DBValue6", "DBValue7", "DBValue8", "DBValue9", "DBValue10"};
    final String originaltext = "This is 4, This is 2, This is 7";
    final Pattern pattern = Pattern.compile("(?<=This is )\\d++");
    final Matcher matcher = pattern.matcher(originaltext);
    final StringBuffer sb = new StringBuffer();
    while (matcher.find()) {
        System.out.println(matcher.group());
        final int index = Integer.parseInt(matcher.group());
        matcher.appendReplacement(sb, values[index]);
    }
    matcher.appendTail(sb);
    System.out.println(sb);
}