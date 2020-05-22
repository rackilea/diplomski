// use a pattern as a constant instead, using the Java naming conventions (all uppercase and underscores)
private static final String MAIL_PATTERN = "[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?";

// lower case method identifier, does not use field so declare static
private static boolean validate(final String email) 
{
    // matches already returns a boolean, you can use matches directly on a string (shorthand notation)
    return email.matches(MAIL_PATTERN);
}