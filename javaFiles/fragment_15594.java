String[] ranges = {"1 - 10", "-1 - -10", "1-10", "-10-5"};
String regex = "(-?\\d+)\\s*-\\s*(-?\\d+)";
Pattern pattern = Pattern.compile(regex);

for (String range : ranges) {
    Matcher matcher = pattern.matcher(range);
    while (matcher.find()) {
        String number1 = matcher.group(1);
        String number2 = matcher.group(2);
        System.out.print(number1 + " " + number2);

    }
    System.out.println();
}