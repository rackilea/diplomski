String input = "Add Job_A with length 10";

Pattern pattern = Pattern.compile("Add (.+) with length (\\d+)");
Matcher matcher = pattern.matcher(input);

if (matcher.matches()) {
    // Input has correct format, we can extract matched values into variables
    String jobName = matcher.group(1);
    int number = Integer.parseInt(matcher.group(2));
} else {
    // Input has incorrect format
}