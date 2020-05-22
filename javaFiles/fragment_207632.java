lexer grammar eatall ;

ValidSimple : { isCurrenLineJustTEXTandWS() }? TEXT ;
-- or --
ValidSimple : TEXT ( WS TEXT)* EOL?  { emitEachTEXTasNewValidSimpleToken(); } ;

ValidEatAll : IgnoreL .*? IgnoreR    { trimIgnoreLRTextfromTokenText(); } ;
Invalid     : WS+ | .*? EOL?         -> channel(HIDDEN) ;

IgnoreL : .*? MARK ;
IgnoreR : MARK .*? EOL? ;

fragment MARK : '| EATALL' ;
fragment TEXT : [a-zA-Z0-9_-] ;
fragment EOL  : '\r'? '\n' ;
fragment WS   : [ \t] ;