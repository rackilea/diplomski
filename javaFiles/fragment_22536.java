grammar Script;

// PARSER

program
 : block EOF
 ;

block
 : ( statement | functionDecl )*
 ;

statement
 : ( variable_def
   | functionCall
   | ifStatement
   | forStatement
   | whileStatement
   )
   ';'
 ;

whileStatement
 : 'while' '(' expression ')' '{' statement* '}'
 ;

forStatement
 :
 ;

ifStatement
 : 'if' '(' expression ')' '{' statement* '}'
   ( ( 'else' '{' statement* '}' ) | ( 'else' ifStatement ) )?
 ;

functionDecl
 : 'function' id ( '(' ( type id )? ( ',' type id )* ')' )?
   ( 'returns' return_type )? '{' statement* '}'
 ;

functionCall
 : id '(' exprList? ')'
 ;

exprList
 : expression ( ',' expression )*
 ;

variable_def
 : type assignment
 | GLOBAL variable_def
 | ROOM variable_def
 ;

expression
 : '-' expression             # unaryMinusExpression
 | '!' expression             # notExpression
 | expression '^' expression  # powerExpression
 | expression '*' expression  # multiplyExpression
 | expression '/' expression  # divideExpression
 | expression '%' expression  # modulusExpression
 | expression '+' expression  # addExpression
 | expression '-' expression  # subtractExpression
 | expression '>=' expression # gtEqExpression
 | expression '<=' expression # ltEqExpression
 | expression '>' expression  # gtExpression
 | expression '<' expression  # ltExpression
 | expression '==' expression # eqExpression
 | expression '!=' expression # notEqExpression
 | expression '&&' expression # andExpression
 | expression '||' expression # orExpression
 | expression IN expression   # inExpression
 | NUMBER                     # numberExpression
 | BOOLEAN                    # boolExpression
 | functionCall               # functionCallExpression
 | '(' expression ')'         # expressionExpression
 ;

assignment
 : id assign expression
 ;

return_type
 : type
 | 'Nothing'
 ;

type
 : TYPE
 | 'Growable'? 'List' OF TYPE
 ;

assign
 : 'is' ( A | AN | THE )?
 ;

equal
 : 'is'? ( EQUAL ( S
                 | TO
                 )?
         | EQUIVALENT TO?
         | THE? SAME AS?
         )
 ;

id
 : ( ID | OF | A | AN | EQUAL | S | EQUIVALENT | TO | THE | SAME | AS )
 ;

// LEXER

// Some keyword you might want to match as an identifier too:
OF : 'of';
A : 'a';
AN : 'an';
EQUAL : 'equal';
S : 's';
EQUIVALENT : 'equivalent';
TO : 'to';
THE : 'the';
SAME : 'same';
AS : 'as';

COMMENT
 : ( LINE_COMMENT | JAVADOC_COMMENT ) -> skip
 ;

WS
 : [ \t\n\r]+ -> skip
 ;

TYPE
 : 'Number'
 | 'String'
 | 'Anything'
 | 'Boolean'
 ;

GLOBAL
 : 'global'
 ;

ROOM
 : 'room'
 ;

IN
 : 'in'
 ;

BOOLEAN
 : 'true'
 | 'false'
 ;

NUMBER
 : '-'? INT '.' INT EXP? // 1.35, 1.35E-9, 0.3, -4.5
 | '-'? '.' INT EXP? // -.35, .35e5
 | '-'? INT EXP // 1e10 -3e4
 | '-'? INT // -3, 45
 ;

STRING
 : '"' .*? '"'
 ;

ID
 : [a-zA-Z_] [a-zA-Z_0-9]*
 ;

fragment EXP
 : [Ee] [+\-]? INT
 ;

fragment INT
 : '0'
 | [1-9] [0-9]*
 ;

fragment JAVADOC_COMMENT
 : '/*' .*? '*/'
 ;

fragment LINE_COMMENT
 : ( '//' | '#' ) ~( '\r' | '\n' )*
 ;