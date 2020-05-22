private static final Pattern pattern = Pattern.compile("\\d+");

public static int total(String input) {
    Matcher matcher = pattern.matcher(input);
    int total = 0;

    while (matcher.find()) {
        total += Integer.parseInt(matcher.group(0));
    }

    return total;
}