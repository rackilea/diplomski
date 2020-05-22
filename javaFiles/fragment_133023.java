grammar T;

SPACE       : [ \t\r\n]+ -> skip
            ;
WITH        : 'WITH'
            ;
NAME        : ('a'..'z' | 'A'..'Z' | '0'..'9' | '-' | '_')+
            ;
query       : NAME (WITH query)?
            ;