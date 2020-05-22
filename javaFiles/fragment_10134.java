final class Visitor extends YourGrammarParserBaseVisitor<String> { // The name of the base visitor should be <your grammar name> + 'ParserBaseVisitor'

    @Override
    public String visitTypeSpecifier(TypeSpecifierContext ctx) { // 'visit' + <name of the rule with the first letter to upper case>
        // Your code here

        return "the result";
    }

    // other visit methods for other rules
}