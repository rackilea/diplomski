StringBuffer out = new StringBuffer();
while (matcher.find()) {
    String r = test[Integer.parseInt(matcher.group(1)) - 1];
    matcher.appendReplacement(out, r);
}
matcher.appendTail(out);
System.out.println(out.toString());