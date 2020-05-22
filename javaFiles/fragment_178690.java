Pattern pattern = Pattern.compile(", *");
Matcher matcher = pattern.matcher(inputString);
if (matcher.find()) {
    string1 = inputString.substring(0, matcher.start());
    string2 = inputString.substring(matcher.end());
}