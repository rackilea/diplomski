grammar T;  

parse
 : line* EOF 
 ;

line
@init{int n = 0;}
 : Num {n = Integer.valueOf($Num.text);} ({n > 0}?=> Block {n--;})*
 ;

Num
 : {getCharPositionInLine()==0}?=> Digit Digit Digit
 ;

Block
 : AlphaNum AlphaNum
 ;

Space
 : (' ' | '\t' | '\r' | '\n')+ {skip();}
 ;

fragment Digit : '0'..'9';
fragment Letter : 'a'..'z' | 'A'..'Z';
fragment AlphaNum : Letter | Digit;