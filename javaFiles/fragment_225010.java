term:   (word | options_list)+
    ;

word:   WORD
    ;

options_list:   '(' term ('|' term)* ')
    ;

WORD:   ('a'..'z' | 'A'..''Z' | '_' | '0'..'9')+
    ;