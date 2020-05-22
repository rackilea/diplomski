grammar T;

options {
  output=AST;
}

parse
 : expr EOF -> expr
 ;

expr
  :  orexp
  ;

orexp
  :  andexp (Or^ andexp)*
  ;

andexp
  :  not (And^ not)*
  ;

not
 : Not^ exists
 | exists
 ;

exists
 : atom (Exists^)?
 ;

atom
 : Num
 | Id
 | '(' expr ')' -> expr
 ;

Or     : 'or';
And    : 'and';
Exists : 'exists';
Not    : 'not';
Num    : '0'..'9'+;
Id     :  ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
Space  : ' ' {skip();};