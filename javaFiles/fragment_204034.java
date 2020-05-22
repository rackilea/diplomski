inp : line         { System.out.print($1); }
    | inp NL line  { System.out.println("NEWLINE WAS HERE"); System.out.print($3); }
    ;

line : /* empty */ { $$ = new StringBuilder(); }
    | line sim     { $$ = $1.append($2).append('\n'); }
    ;

sim : ID
    | NUM
    ;