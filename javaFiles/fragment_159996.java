StreamLexer tokens = new StreamLexer(yourInputStream); // custom lexer
    YourParser parser = new YourParser(tokens);
    parser.removeErrorListeners(); // remove ConsoleErrorListener
    parser.addErrorListener(new YourErrorListener());
    parser.setErrorHandler(new YourParserErrorStrategy());
    parser.start();