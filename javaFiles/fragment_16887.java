Pattern pattern = Pattern.compile("{{((.*?)*?)}}");
Matcher matcher = pattern.matcher(input);
while (matcher.find()) {
    // Other stuff, like extracting values
    String value = matcher.group(1)
    // Then you can just String.replace the matches.
}