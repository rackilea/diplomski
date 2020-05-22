String source = "//SYSIN    DD  *     \r\n" +
        "SORT FIELDS=COPY\r\n" +
        "INCLUDE COND\r\n" +
        "any other program input @ $ ! & %\r\n" +
        "/*";

DDGrammarLexer lexer = new DDGrammarLexer(CharStreams.fromString(source));
DDGrammarParser parser = new DDGrammarParser(new CommonTokenStream(lexer));

parser.ddstmt();