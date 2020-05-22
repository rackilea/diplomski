grammar JCL;

/* Parsing JCL, ignoring inline sysin. */

jcl
    :   jcl_card+   // good old punched cards :-)
    ;

jcl_card
    :   dd_statement
    |   COMMENT
    ;

dd_statement
    :   '//' NAME 'DD' file_type ( NL | EOF )
    ;

file_type
    :   'DUMMY'
    |   'DYNAM'
    |   NAME '=' ( '*' | NAME )
    |   '*' NL inline_sysin
    ;

inline_sysin
    :   NON_JCL_CARD* END_OF_FILE
    ;

NAME          : [A-Z#] ( LETTER | DIGIT | SPECIAL_CHARS )* ;
COMMENT       : '//*' .*? ( NL | EOF ) ;
END_OF_FILE   : '/'  {getCharPositionInLine() == 1}? '*' ;
NON_JCL_CARD  : ~'/' {getCharPositionInLine() == 1}? .*? ( NL | EOF ) ;
STRING        : '\'' .*? '\'' | '"' .*? '"' ;
NL  : [\r\n] ;
WS  : [ \t]+ -> skip ; // or -> channel(HIDDEN) to keep white space tokens

fragment DIGIT  : [0-9] ;
fragment LETTER : [A-Z] ;
fragment SPECIAL_CHARS : '#' | '@' | '$' ;