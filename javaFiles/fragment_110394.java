// ((?:\w+\W?){3})(?:(\W+|$))
String text = "chill hit donkey chicken car roast pink rat tree";
String regex = "((?:\\w+\\W?){3})(?:(\\W+|$))";
Matcher m = Pattern.compile(regex).matcher(text);
while (m.find()) {
    System.out.println(String.format("'%s'", m.group(1)));
}