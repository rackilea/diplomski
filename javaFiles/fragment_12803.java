listAll   :   ( system | home )* ;

elements  :   ( sp | cpu )* ;

home      :   'home['  number ']' value elements;

system    :   'system' ;

sp        :   'sp' ;

cpu       :   'cpu[' number ']' ;

value     :   VALUE ;

number    :   INT ;

VALUE     :   STRING+; 

STRING    :   ('a'..'z'|'A'..'Z'| '-' | '(' | ')' | '/' | '.' | '[' | ']') ;

INT       :   [0-9]+ ;

WS        :   [ \t\r\n]+ -> skip ;