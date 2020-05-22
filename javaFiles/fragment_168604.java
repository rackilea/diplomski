select      : 'select' NAME '[' anything ']'
            ;
anything    : (ANYTHING | NAME)+
            ;

NAME        : ('a'..'z' | 'A'..'Z' | '0'..'9' | '-' | '_')+
            ;
WHITESPACE  : ('\t' | ' ' | '\r' | '\n')+ -> skip
            ;
ANYTHING    : (~(']' | '['))+?
            ;