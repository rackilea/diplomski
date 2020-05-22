Pattern patt = Pattern.compile("(.{3})-(.{3}) (\d+)");
Matcher matcher = patt.matcher(qaurterString);
if(! matcher.find() || m.groupCount() != 3) {
    throw new ParseException(...)
}
String fromMonth = matcher.group(1);
String toMonth = matcher.group(2);
int year = Integer.parseInt(matcher.group(3));