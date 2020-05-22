grammar JavaGrammar;

import P, L;

@parser::members {
  public static void main(String[] args) throws Exception {
    L lexer = new L(new ANTLRStringStream("SO;"));
    JavaGrammarParser parser = new JavaGrammarParser(new CommonTokenStream(lexer));
    parser.jStatement(); 
  }
}

jStatement
 : statement 
   {
     System.out.println("statement       = '" + $statement.text + "'\n" + 
                        "statement.first = '" + $statement.first + "'\n" + 
                        "statement.last  = '" + $statement.last + "'");
   } 
 ;