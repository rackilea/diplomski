StringBuffer res = new StringBuffer();
Pattern regex = Pattern.compile("[*]");
Matcher matcher = regex.matcher("Quick * fox jumps * the * dog");
int pos = 0;
String[] array = {"brown", "over", "lazy"};
while (matcher.find()) {
    String replacement = pos != array.length ? array[pos++] : "*";
    matcher.appendReplacement(res, replacement);
} 
matcher.appendTail(res);