grammar Test;

@parser::members {
  public static void main(String[] args) throws Exception {
    String text = "(a, bb ,  ccc )";
    ANTLRStringStream in = new ANTLRStringStream(text);
    TestLexer lexer = new TestLexer(in);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    System.out.println(new TestParser(tokens).mainRule());
  }
}

mainRule returns [List<String> words]
@init{$words = new ArrayList<String>();}
  :  '(' w=WORD {$words.add($w.text);} (',' w=WORD {$words.add($w.text);} )* ')'
  ;

WORD
  :  ('a'..'z'|'A'..'Z'|'0'..'9')+
  ;

WS
  :  ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ { $channel = HIDDEN; }
  ;