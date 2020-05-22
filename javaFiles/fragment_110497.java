grammar names;

fullname : TITLE? first=NAME last=NAME;

TITLE : 'Mr.' | 'Ms.' | 'Mrs.' ;

NAME : ('A'..'Z' | 'a'..'z')+ ;

WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ -> skip ;