String[] parts = data.split("\\*");
Pattern pattern = Pattern.compile(
    Stream.of(parts).map(Pattern::quote).collect(Collectors.joining(".*")));

if (pattern.matcher(text).find()) {
    return text;
}