@Override
public Object visitTerminal(TerminalNode node) {
    int type = node.getSymbol().getType(); // matches a constant in your parser

    switch (type) {
        case GrammParser.NUMERIC_LITERAL:
            System.out.println("numeric literal");
            break;
        case GrammParser.STRING_LITERAL:
            System.out.println("string literal");
            break;
    }

    System.out.println(node.getSymbol().getText());
    return super.visitTerminal(node); 
}