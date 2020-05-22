grammar twp3;

type          : primitiveType  | Identifier | 'any' 'defined' 'by' Identifier;
primitiveType : 'int' | 'string' | 'binary' | 'any';
field         : 'optional'? type Identifier ';';

Identifier : LETTER (LETTER | DIGIT)*;
Number     : DIGIT+;

fragment ALPHA  : ('a'..'z'|'A'..'Z'); 
fragment DIGIT  : ('0' .. '9');
fragment LETTER : ALPHA | '_';