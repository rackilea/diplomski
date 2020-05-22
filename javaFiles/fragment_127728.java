Pattern pattern = Pattern.compile(getPattern(stationSelected));
Matcher matcher = pattern.matcher(title);
if (matcher.find()) {
    System.out.println("Title : " + matcher.group(1));
} else {
    System.err.println("The title doesn't match the format");
}