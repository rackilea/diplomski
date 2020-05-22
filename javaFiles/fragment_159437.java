grammar Exp;

@parser::members {

  private java.util.HashMap<String, Double> memory = new java.util.HashMap<String, Double>();

  public static Double eval(String expression) throws Exception {
    return eval(expression, new java.util.HashMap<String, Double>()); 
  }

  public static Double eval(String expression, java.util.Map<String, Double> vars) throws Exception {
    ANTLRStringStream in = new ANTLRStringStream(expression);
    ExpLexer lexer = new ExpLexer(in);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    ExpParser parser = new ExpParser(tokens);
    parser.memory.putAll(vars);
    return parser.parse(); 
  }
}

parse returns [double value]
    :    exp=additionExp {$value = $exp.value;}
    ;

additionExp returns [double value]
    :    m1=multiplyExp      {$value =  $m1.value;} 
        ( '+' m2=multiplyExp {$value += $m2.value;} 
        | '-' m2=multiplyExp {$value -= $m2.value;}
        )*  
    ;

multiplyExp returns [double value]
    :   a1=atomExp       {$value =  $a1.value;}
        ( '*' a2=atomExp {$value *= $a2.value;} 
        | '/' a2=atomExp {$value /= $a2.value;}
        )*  
    ;

atomExp returns [double value]
    :    n=Number                {$value = Double.parseDouble($n.text);}
    |    i=Identifier            {$value = memory.get($i.text);}
    |    '(' exp=additionExp ')' {$value = $exp.value;}
    ;

Identifier
    :    ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')*
    ;

Number
    :    ('0'..'9')+ ('.' ('0'..'9')+)?
    ;

WS  
    :   (' ' | '\t' | '\r'| '\n') {$channel=HIDDEN;}
    ;