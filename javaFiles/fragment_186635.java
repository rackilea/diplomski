grammar BlockSpeak;

parse
 : instruction* EOF
 ;

instruction
 : create_block
 | stack_block
 ;

create_block
 : 'block' NAME 'at' position
 ;

stack_block
 : 'stack' top=NAME 'on' bottom=NAME
 ;

position
 : '(' x=INT ',' y=INT ')'
 ;

COMMENT
 : '#' ~[\r\n]* -> skip
 ;

INT
 : [0-9]+
 ;

NAME
 : [a-zA-Z]+
 ;

SPACES
 : [ \t\r\n] -> skip
 ;