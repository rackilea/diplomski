String line = "\"1,31\"";

Pattern pattern = Pattern.compile("\"(\\d+),(\\d+)\"");
Matcher matcher = pattern.matcher(line);
if (matcher.matches()) {
    int firstNumber = Integer.parseInt(matcher.group(1));
    int secondNumber = Integer.parseInt(matcher.group(2));
    // do whatever with the numbers
}