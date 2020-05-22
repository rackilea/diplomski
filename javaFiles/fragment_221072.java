grammar FJS;

@parser::members {FJSObject obj = new FJSObject();}

parse
    :   'namespace' ':' p=packageOrClass {obj.namespace = $p.text;}
        '{'
            useStatement*
            objDeclaration
        '}'
    ;

useStatement
    :   'use' ':' p=packageOrClass {obj.use.add($p.text);} ';'
    ;

includeStatement
    :   'include' ':' s=StringLiteral {obj.include.add($s.text);} ';'
    ;

objDeclaration
    :   'declare' ':' i=Identifier {obj.name = $i.text;} 
        ( '<' p=packageOrClass {obj.inherit = $p.text;} )? 
        ( '|' p=packageOrClass {obj.resemble.add($p.text);} )* 
        '{' 
            includeStatement* 
            // ...
        '}'
    ;

packageOrClass
    :   ( Identifier ( '.' Identifier )* )
    ;

StringLiteral
    :   '"' ( '\\\\' | '\\"' | ~( '"' | '\\' ) )* '"'
    ;

Identifier
    :   ( 'a'..'z' | 'A'..'Z' | '_' ) ( 'a'..'z' | 'A'..'Z' | '_' | '0'..'9' )* 
    ;

LineComment
    :   '//' ~( '\r' | '\n' )* ( '\r'? '\n' | EOF ) {skip();} // ignoring these tokens
    ;

Spaces
    :   ( ' ' | '\t' | '\r' | '\n' ) {skip();} // ignoring these tokens
    ;