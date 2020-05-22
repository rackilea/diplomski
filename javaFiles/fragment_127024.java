final exprLexer lexer = new exprLexer(CharStreams.fromString("A=10\nB = A * A\n"));
final CommonTokenStream tokens = new CommonTokenStream(lexer);
final exprParser parser = new exprParser(tokens);
final ParseTree tree = parser.prog();
ParseTreeWalker.DEFAULT.walk(new exprBaseListener()
{
    final String INDENT = "    ";
    int level = 0;
    @Override
    public void enterEveryRule(final ParserRuleContext ctx)
    {
        System.out.printf("%s<%s>%n", indent(), parser.getRuleNames()[ctx.getRuleIndex()]);
        ++level;
        super.enterEveryRule(ctx);
    }

    @Override
    public void exitEveryRule(final ParserRuleContext ctx)
    {
        --level;
        System.out.printf("%s</%s>%n", indent(), parser.getRuleNames()[ctx.getRuleIndex()]);
        super.exitEveryRule(ctx);
    }

    @Override
    public void visitTerminal(final TerminalNode node)
    {
        final String value = node.getText();
        if (!value.matches("\\s+"))
        {
            System.out.printf("%s<t>%s</t>%n", indent(), node.getText());
        }
        super.visitTerminal(node);
    }

    private String indent()
    {
        return String.join("", Collections.nCopies(level, INDENT));
    }
}, tree);