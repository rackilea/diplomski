// Create an input stream that receives text from the terminal
ANTLRInputStream input = new ANTLRInputStream(System.in);

// Create an Lexer that receives the char stream
ExampleLexer lexer = new ExampleLexer(input);

// Create a token stream from the lexer
CommonTokenStream tokens = new CommonTokenStream(lexer);

// Create a parser that receives the token stream
ExampleParser parser = new ExampleParser(tokens);

// Create a parser tree starting from the first rule
TestContext tree = parser.test();

//Generates the GUI
tree.inspect(parser);