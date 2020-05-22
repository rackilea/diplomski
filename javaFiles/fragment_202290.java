grammar T;

@parser::members {
  private java.util.Map<String, Integer> memory = new java.util.HashMap<String, Integer>();
}

parse
@init{
  // initialize some test values
  memory.put("AGE", 42);
  memory.put("DEPARTMENT", 999);
  memory.put("EMPID", 1001);
}
 : expression EOF {System.out.println($text + " -> " + $expression.value);}
 ;

expression returns [Object value]
 : logical {$value = $logical.value;}
 ;

logical returns [Object value]
 : e1=equality {$value = $e1.value;} ( 'AND' e2=equality {$value = (Boolean)$value && (Boolean)$e2.value;}
                                     | 'OR' e2=equality  {$value = (Boolean)$value || (Boolean)$e2.value;}
                                     )*
 ;

equality  returns [Object value]
 : r1=relational {$value = $r1.value;} ( '=' r2=relational  {$value = $value.equals($r2.value);}
                                       | '!=' r2=relational {$value = !$value.equals($r2.value);}
                                       )*
 ;

relational returns [Object value]
 : a1=atom {$value = $a1.value;} ( '>=' a2=atom {$value = (Integer)$a1.value >= (Integer)$a2.value;}
                                 | '>'  a2=atom {$value = (Integer)$a1.value >  (Integer)$a2.value;}
                                 | '<=' a2=atom {$value = (Integer)$a1.value <= (Integer)$a2.value;}
                                 | '<'  a2=atom {$value = (Integer)$a1.value <  (Integer)$a2.value;}
                                 )?
 ;

atom returns [Object value]
 : INTEGER            {$value = Integer.valueOf($INTEGER.text);}
 | ID                 {$value = memory.get($ID.text);}
 | '(' expression ')' {$value = $expression.value;}
 ;

INTEGER : '0'..'9'+;
ID      : ('a'..'z' | 'A'..'Z')+;
SPACE   : ' ' {$channel=HIDDEN;};