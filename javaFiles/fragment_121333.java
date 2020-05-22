Matcher matcher = Pattern.compile("(\\d+)\\s+(\\d+)\\s+(\\d+)").matcher(reader.nextLine());
if (matcher.matches()) {
    int height = Integer.parseInt(matcher.group(1));
    int width = Integer.parseInt(matcher.group(2));
    int depth = Integer.parseInt(matcher.group(3));
} else {
    // input was invalid!
}