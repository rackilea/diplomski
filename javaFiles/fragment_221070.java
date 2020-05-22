parse
    :   'namespace' ':' packageOrClass '{'
            useStatement*
            objDeclaration
        '}'
    ;

useStatement
    :    'use' ':' packageOrClass ';'
    ;

includeStatement
    :    'include' ':' StringLiteral ';'
    ;

objDeclaration
    :    'declare' ':' Identifier ( '<' packageOrClass )? ( '|' packageOrClass )* '{' 
             includeStatement* 
         '}'
    ;

packageOrClass
    :    ( Identifier ( '.' Identifier )* )
    ;

StringLiteral
    :    '"' ( '\\\\' | '\\"' | ~( '"' | '\\' ) )* '"'
    ;

Identifier
    :    ( 'a'..'z' | 'A'..'Z' | '_' ) ( 'a'..'z' | 'A'..'Z' | '_' | '0'..'9' )*    
    ;

LineComment
    :    '//' ~( '\r' | '\n' )* ( '\r'? '\n' | EOF )     
    ;

Spaces
    :    ( ' ' | '\t' | '\r' | '\n' )     
    ;