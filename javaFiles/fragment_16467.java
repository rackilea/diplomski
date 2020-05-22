grammar temp;
options {output=AST;}
tokens { KLASS; FIELD; METHOD; }

klass   :   'class' ID body -> ^(KLASS ID body)
        ;

body    :   '{'!
                (field | method) *
            '}'! 
        ;

field   : 'field' INT -> ^(FIELD INT)
        ;

method  : 'method' INT -> ^(METHOD INT)
        ;

ID      : ('a'..'z')+;
INT     : ('0'..'9')+;
WS      : (' '|'\r'|'\n')+ {$channel = HIDDEN;} ;