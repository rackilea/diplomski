grammar Java6;

// options ...

@parser::members{
  public static void main(String[] args) throws Exception {
    String source = "package test;\n\npublic class Test {\n\n  int n = 42;\n}\n";
    Java6Lexer lexer = new Java6Lexer(new ANTLRStringStream(source));
    Java6Parser parser = new Java6Parser(new CommonTokenStream(lexer));
    System.out.println(source);
    parser.dumpTokens();
  }
}

dumpTokens
  :  (
       t=. {
         CommonToken ct = (CommonToken)t;
         System.out.printf("type=\%s, text='\%s', line=\%d, startIndex=\%d, charPositionInLine=\%d\n", 
                            tokenNames[ct.getType()], 
                            ct.getText(), 
                            ct.getLine(), 
                            ct.getStartIndex(), 
                            ct.getCharPositionInLine());
       }
     )* 
     EOF
  ;

// the rest of the grammar rules are not changed