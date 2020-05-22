private List<Token> tokenizeMethod(String method) {
    JavaLexer lex = new JavaLexer(new ANTLRInputStream(method));
    CommonTokenStream tokStream = new CommonTokenStream(lex);
    tokStream.fill();

    return tokStream.getTokens();
}


/**
 * Returns the number of reserved words inside the given method, using lexical analysis
 * @param method The method text
 */
private int countReservedWords(String method) {
    int count = 0;

    for(Token t : tokenizeMethod(method)) {
        if(t.getType() <= JavaLexer.WHILE) {
            count++;
        }
    }

    return count;
}