String inputString = "Republic SS1234 and ABC 1234";
Pattern pattern = Pattern.compile(
    "(?i)\\b([A-Z]{3} ?[0-9]{3,4}|[A-Z]{2} ?[0-9]{4}|[0-9]{4} ?[A-Z]{2})\\b");
Matcher matcher = pattern.matcher(inputString);
while (matcher.find()) {
    String platenumber = matcher.group(1);
    . . .
}