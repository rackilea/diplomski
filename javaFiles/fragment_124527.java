array_init
 : expr ( ',' expr )*
 ;

expr
 : '(' expr ')'          #nestedExpr
 | lhs=expr '+' rhs=expr #addExpr
 | INT                   #intExpr
 | ID                    #idExpr
 ;