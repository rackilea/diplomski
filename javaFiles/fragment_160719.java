Pattern pattern = Pattern.compile(
    "[ ](?:inc|ltd|corp)\\b\\.?",
    Pattern.CASE_INSENSITIVE
);
Matcher matcher = pattern.matcher(str);
str = matcher.replaceAll("");