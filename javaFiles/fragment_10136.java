final class Visitor extends YourGrammarParserBaseVisitor<String> {

    @Override
    public String visitTypeSpecifier(TypeSpecifierContext ctx) {
        return super();
    }

    @Override
    public String visitIntTypeSpecifier(IntTypeSpecifierContext ctx) {
        return 'int'; // or ctx.getText()
    }

    // Rest of the rules
}