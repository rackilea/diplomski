@Override
public Object visitLiteral(LiteralContext ctx) {            
    TerminalNode numeric = ctx.NUMERIC_LITERAL();
    TerminalNode string = ctx.STRING_LITERAL();
    if (numeric != null) {
        System.out.println(numeric.getSymbol().getType());
    } else if (string != null) {
        System.out.println(string.getSymbol().getType());
    }
    return super.visitLiteral(ctx);
}