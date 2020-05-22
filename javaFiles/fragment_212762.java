LexerGrammar lg = new LexerGrammar(
    "lexer grammar L;\n" +
    "A : 'a' ;\n" +
    "B : 'b' ;\n" +
    "C : 'c' ;\n");
Grammar g = new Grammar(
    "parser grammar T;\n" +
    "s : (A|B)* C ;\n",
    lg);

for (String ruleName : g.getRuleNames()) {
    Rule rule = g.getRule(null, ruleName);
    // ...
}