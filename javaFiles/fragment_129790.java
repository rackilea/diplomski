grammar T;

options {
  output=AST;
}

tokens {
  ASSIGN;
  IND;
  FA;
}

parse
 : assign EOF -> assign
 ;

assign
 : lookup '=' expr ';' -> ^(ASSIGN lookup expr)
 ;

expr
 : lookup
 ;

lookup
 : (NAME -> NAME) ( array_index  -> ^(IND $lookup array_index)
                  | field_access -> ^(FA $lookup field_access)
                  )*
 ;

array_index
 : '[' expr ']' -> expr
 ;

field_access
 : '.' NAME -> NAME
 ;

NAME  : 'a'..'z'+;
SPACE : ' ' {skip();};