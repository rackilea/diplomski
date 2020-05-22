stats_statement
 : STATS ident ASSIGN_SYM functions_stats
 ;

functions_stats 
 :   COUNT LPAREN ident RPAREN   
 ;

ident
 : COUNT
 | IDENT
 ;