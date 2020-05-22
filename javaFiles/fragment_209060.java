grammar T;

options { 
 output=AST; 
}

tokens { 
 MY_STATEMENT;
 TEXT;
}

statement
 : 'blah' subrule ';' -> ^(MY_STATEMENT subrule TEXT[$statement.text])
 ;

subrule
 : Digit Digit
 ;

Digit
 : '0'..'9'
 ;