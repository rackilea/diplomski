@Override
public SyntaxErrorMessage getSyntaxErrorMessage(IParserErrorContext context) {
    if (context.getRecognitionException() instanceof MismatchedTokenException) {
        MismatchedTokenException exception = (MismatchedTokenException) context.getRecognitionException();
        String value = exception.token.getText();
        return new SyntaxErrorMessage("The type of " + value + " is wrong.", IssueCodes.FALSE_PARAMETER_TYPE);
    }
    // additional implementations
    return null;
}