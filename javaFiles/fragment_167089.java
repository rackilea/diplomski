private static final Pattern VALID_WORD = Pattern.compile("^[A-Za-z]*$");

...

if (!VALID_WORD.matcher(text.getText()).matches()) {
   // Show some appropriate error message
}