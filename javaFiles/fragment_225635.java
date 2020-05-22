private static final Pattern ADDRESS_STRING_PATTERN = Pattern.compile("^[\\p{L}\\d\\s\\p{P}\\p{S}]{1,200}$");
private static boolean isValidInput(final String input, Pattern pattern) {
        return pattern.matcher(input).matches();
}
public static void main (String[] args) throws java.lang.Exception
{
    System.out.println(isValidInput("こんにちは、元気ですか",ADDRESS_STRING_PATTERN));
}
// => true