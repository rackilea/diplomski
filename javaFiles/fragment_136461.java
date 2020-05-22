grammar Exp;

@header {
//    package antlr.output;
  import java.util.HashMap;
}

@parser::members {

  private HashMap<String, Double> memory = new java.util.HashMap<String, Double>();

  public static Double eval(String expression) throws Exception {
    return eval(expression, new java.util.HashMap<String, Double>()); 
  }

  public static Double eval(String expression, java.util.Map<String, Double> vars) throws Exception {
    ANTLRInputStream in = new ANTLRInputStream(expression);
    ExpLexer lexer = new ExpLexer(in);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    ExpParser parser = new ExpParser(tokens);
    parser.memory.putAll(vars);
    ParseContext ctx = parser.parse();
    return ctx.expression().value;
  }
}

parse
@init {System.out.println("Exp last update 1843");}
    :   expression
        {System.out.println("Expression " + $expression.text + "=" + $expression.value);}
    ;

expression returns [double value]
    :   e1=expression            {$value =  $e1.value;}
        (   op='*' e2=expression {$value *= $e2.value;} 
          | op='/' e2=expression {$value /= $e2.value;}
        )
        {System.out.println("Mult " + $e1.text + ($op.text != null ? $op.text + $e2.text + "=" + $value : ""));}
    |   e1=expression            {$value =  $e1.value;} 
        (   op='+' e2=expression {$value += $e2.value;} 
          | op='-' e2=expression {$value -= $e2.value;}
        )
        {System.out.println("Add " + $e1.text + ($op.text != null ? $op.text + $e2.text + "=" + $value : ""));}
    |   '(' expression ')'       {$value = $expression.value;}
    |   function                 {$value = $function.value;
                                  System.out.println("Function " + $function.text + "=" + $value);
                                 }
    |   atom                     {$value = $atom.value;}
    ;

function returns [double value]
    :   '@' 'cos' expression {$value = Math.cos($expression.value);}
    |   '@' 'sin' expression {$value = Math.sin($expression.value);}
    ;

atom returns [double value]
    :   NUMBER                {$value = Double.parseDouble($NUMBER.text);}
    |   IDENTIFIER            {System.out.println("Found ID=<" + $IDENTIFIER.text + ">");
                               $value = memory.get($IDENTIFIER.text);
                               System.out.println("Found " + $IDENTIFIER.text + "=" + $value);
                              }
    ;

IDENTIFIER
    :    ( LETTER | '_' ) ( LETTER | '_' | DIGIT )*
    ;

NUMBER
    :    DIGIT+ ( '.' DIGIT+ )?
    ;


WS      : [ \t\r\n] -> channel(HIDDEN) ;

fragment LETTER : [a-zA-Z] ;
fragment DIGIT  : [0-9] ;