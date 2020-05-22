final String DOUBLE = "\\d+(?:\\.\\d+)?";
final Pattern PATTERN = Pattern.compile(DOUBLE + ", " + DOUBLE + ", \\d+");
Matcher matcher = PATTERN.matcher(textView.getText().toString());
if (!matcher.matches()) {
    // invalid input
}