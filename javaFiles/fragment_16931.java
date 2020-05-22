String source = "x=10\n" +
        "while x>2 :\n" +
        "    print(\"hello\")\n" +
        "        x=x-3\n";

Python3Lexer lexer = new Python3Lexer(CharStreams.fromString(source));
Python3Parser parser = new Python3Parser(new CommonTokenStream(lexer));

// Remove default error-handling
parser.removeErrorListeners();

// Add custom error-handling
parser.addErrorListener(new BaseErrorListener() {
  @Override
  public void syntaxError(Recognizer<?, ?> recognizer, Object o, int i, int i1, String s, RecognitionException e) {

    CommonToken token = (CommonToken) o;

    if (token.getType() == Python3Parser.INDENT) {
      // The parser encountered an unexpected INDENT token
      // TODO throw your exception
    }

    // TODO handle other errors
  }
});

// Trigger the error
parser.file_input();