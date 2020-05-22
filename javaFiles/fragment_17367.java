grammar T;

parse
 : expression EOF
 ;

expression
 : expression 'AND' expression
 | expression 'OR' expression
 | function
 | bool
 | TEXT
 | NUMBER
 | TEXT
 | ID
 ;

function
 : ID '(' arguments? ')'
 ;

arguments
 : expression ( ',' expression )*
 ;

bool
 : TRUE
 | FALSE
 ;

TRUE         : 'true';
FALSE        : 'false';
NUMBER       : ( [0-9]* '.' )? [0-9]+;
ID           : [a-zA-Z_] [a-zA-Z0-9_]*;
TEXT         : '\'' ~[\r\n']* '\'';
SPACE        : [ \t\r\n]+ -> skip;