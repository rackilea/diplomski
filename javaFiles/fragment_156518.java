Pattern keyValuePattern = Pattern.compile("([a-zA-Z0-9]+):\"((?:[^\\\\\"]|\\\\.)*+)\"");
Matcher matcher = keyValuePattern.matcher(inputString);

while (matcher.find()) {
    String key = matcher.group(1);

    // Process the escape sequences in the value string
    String value = matcher.group(2).replaceAll("\\\\(.)", "$1");

    // ...
}