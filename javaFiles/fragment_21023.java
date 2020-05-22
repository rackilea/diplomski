public static String increment(String number) {
    Pattern compile = Pattern.compile("^(.*?)([0-9]*|[A-Z]*)$");
    Matcher matcher = compile.matcher(number);
    String remaining = number;
    String currentGroup = "";
    String result = "";

    boolean continueToNext = true;
        while (matcher.matches() && continueToNext) {
        remaining = matcher.group(1);
        currentGroup = matcher.group(2);
        int currentGroupLength = currentGroup.length();
        int base = currentGroup.matches("[0-9]*") ? 10 : 36;
        currentGroup = Long.toString(Long.parseLong("1" + currentGroup, base) + 1, base);  // The "1" if just to ensure that "000" doesn't become 0 (and thus losing the original string length)
        currentGroup = currentGroup.substring(currentGroup.length() - currentGroupLength, currentGroup.length());
        continueToNext = Long.valueOf(currentGroup, base) == 0;
        if (base == 36) {
            currentGroup = currentGroup.replace("0", "A");
        }

        result = currentGroup + result;
        matcher = compile.matcher(remaining);
    }

    result = remaining + result;
    return result.toUpperCase();
}