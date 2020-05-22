grammar Logic;

options {
  output=AST;
}

tokens {
  NOT_LIKE;
}

parse
  :  expression EOF!
  ;

expression
  :  orexp
  ;

orexp
  :  andexp (Or^ andexp)*
  ;

andexp
  :  fuzzyexp (And^ fuzzyexp)*
  ;

fuzzyexp
  :  (notexp -> notexp) ( Matches e=notexp  -> ^(Matches $fuzzyexp $e)
                        | Not Like e=notexp -> ^(NOT_LIKE $fuzzyexp $e)
                        | Like e=notexp     -> ^(Like $fuzzyexp $e)
                        )?
  ;

notexp
  :  Not^ atom
  |  atom
  ;

atom
  :  ID
  |  '('! expression ')'!
  ;

And     : 'and';
Or      : 'or';
Not     : 'not';
Like    : 'like';
Matches : 'matches';
ID      : ('a'..'z' | 'A'..'Z')+;
Space   : (' ' | '\t' | '\r' | '\n')+ {$channel=HIDDEN;};