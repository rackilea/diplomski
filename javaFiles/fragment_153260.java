class Parser
{
    private Lexer lex;

    public Parser()
    {
        lex = new Lexer();
    }

    public Parser (String s)
    {
        lex = new Lexer (s);
    }