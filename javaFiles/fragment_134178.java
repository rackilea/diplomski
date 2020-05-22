Matcher twoInts = Pattern.compile("(\\d+)\\D*(\\d+)").matcher(input);
if (twoInts.find()) {
    int1 = Integer.parseInt(twoInts.group(1));
    int2 = Integer.parseInt(twoInts.group(2));
} // else uh oh?

Matcher anyNonDigit = Pattern.compile("([^\\d\\s]+)").matcher(input);
if (anyNonDigit.find()) {
    op = anyNonDigit.group(1).charAt(0);
} // else uh oh?