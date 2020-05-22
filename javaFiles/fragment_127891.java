grammar Logic;

@header {
  import expression.*;
}

expression returns [Expression value]
 : d1=disjunction                      {$value = $d1.value;}
 | d2=disjunction IMPLIES e=expression {$value = new Implication($d2.value, $e.value);}
 ;

disjunction returns [Expression value]
 : c1=conjunction                  {$value = $c1.value;}
 | d=disjunction OR c2=conjunction {$value = new Disjunction($d.value, $c2.value);}
 ;

conjunction returns [Expression value]
 : n1=negation                   {$value = $n1.value;}
 | c=conjunction AND n2=negation {$value = new Conjunction($c.value, $n2.value);}
 ;

negation returns [Expression value]
 : variable         {$value = $variable.value;}
 | NOT n=negation   {$value = new Negation($n.value);}
 | OB expression CB {$value = $expression.value;}
 ;

variable returns [Expression value]
 : VAR {$value = new Variable($VAR.text);}
 ;

IMPLIES : '->';
OR      : '|';
AND     : '&';
NOT     : '!';
OB      : '(';
CB      : ')';
VAR     : [A-Z]([0-9])*;
SPACE   : [ \t\r\n] -> skip;