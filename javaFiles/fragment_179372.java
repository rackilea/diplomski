grammar Method;

method      : ('map' | 'get') '(' element (',' element )* ')';
element     : method | parameter;
parameter   : '%' dynamic type* '%';
dynamic     : 'set' '@' ID | 'key' '@' ID | '$' NUMBER;
type        : ':' ID;

ID          : [a-zA-Z]+;
NUMBER      : [0-9]+;
Skip        : [ \t\n\r]+ -> skip;