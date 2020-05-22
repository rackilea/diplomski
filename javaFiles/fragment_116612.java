String input = "*tried string".toLowerCase();

Matcher matcher = Pattern.compile("(?:^| )[^a-z]*[a-z]").matcher(input);

StringBuffer result = new StringBuffer();
while (matcher.find()) {
    matcher.appendReplacement(result, matcher.group().toUpperCase());
}

matcher.appendTail(result);