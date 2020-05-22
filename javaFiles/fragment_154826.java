public static class TpinContext extends ParserRuleContext {
    public Token INT;
    public TerminalNode PREFIX() { return getToken(QuestionParser.PREFIX, 0); }
    public TerminalNode INT() { return getToken(QuestionParser.INT, 0); }
    public TerminalNode EXTRA() { return getToken(QuestionParser.EXTRA, 0); }
    public TerminalNode SUFFIX() { return getToken(QuestionParser.SUFFIX, 0); }