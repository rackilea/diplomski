grammar DebugMe;


compilationUnit : statements EOF;
statements      : statement+;
statement       : block | call | decl;
block           : LCUR statements RCUR;    
call            : ID LPAR arglist? RPAR SEMI;
arglist         : ID (COMMA ID)*;    
decl            : VAR ID EQ expr SEMI;
expr            : add_expr;     

add_expr        : primary_expr ((PLUS|MINUS) primary_expr)*;    
primary_expr    : STRING | ID | INT | LPAR expr RPAR;    

VAR: 'var';   
ID: ('a'..'z'|'A'..'Z')+;
INT: ('0'..'9')+;
STRING: '"' ~('\r'|'\n'|'"')* '"';
SEMI: ';';
LPAR: '(';
RPAR: ')';
LCUR: '{';
RCUR: '}';
PLUS: '+';
MINUS: '-';    
COMMA: ',';
EQ: '=';
WS: (' '|'\t'|'\f'|'\r'|'\n') {skip();};