grammar T;

tokens {
  DOC_COMMENT;
}

@parser::members {
  public static void main(String[] args) throws Exception {
    TLexer lexer = new TLexer(new ANTLRStringStream("/**/ /*foo*/ /**bar*/"));
    TParser parser = new TParser(new CommonTokenStream(lexer));
    parser.parse();
  }
}

parse
  :  (t=. {System.out.println(tokenNames[$t.type] + " :: " + $t.text);})* EOF
  ;

COMMENT
  :  '/*' (~'*' .*)? '*/'
  |  '/**' ~'/' .* '*/' {$type=DOC_COMMENT;}
  ;

SPACE
  :  ' ' {$channel=HIDDEN;}
  ;