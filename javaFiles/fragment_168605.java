SELECT      : 'select' ;
L_BRACKET   : '[';
R_BRACKET   : ']';

NAME        : ('a'..'z' | 'A'..'Z' | '0'..'9' | '-' | '_')+ ;
WHITESPACE  : ('\t' | ' ' | '\r' | '\n')+ -> skip ;
ANY         : . ;

select      : SELECT NAME L_BRACKET anything R_BRACKET ;
anything    : (~R_BRACKET)+ ;