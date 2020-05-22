String THE_PATTERN = "<a\\s+href\\s*=\\s*\"/([a-zA-Z]+)/([0-9]+)";
Matcher m = Pattern.compile(THE_PATTERN).matcher(THE_INPUT_STRING);
String[] results = new String[2];
if (m.find()) {
    results[0] = m.group(1);
    results[1] = m.group(2);
}