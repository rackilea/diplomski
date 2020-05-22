Pattern p = Pattern.compile(
    "(?m)^(\\d{2})(\\d{1,2})(\\d{1,2})\\s+(\\d{1,2}):(\\d{1,2}):(\\d{1,2})\\s+(\\S+)\\s+((?:(?!\\d{4}-\\d{1,2}-\\d{1,2}).)*)");
Matcher m = p.matcher(s);
while (m.find()) {
    // matched text: m.group()
}