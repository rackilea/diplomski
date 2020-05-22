rule
 : INTEGER ':' ro=rocommand i1=INTEGER ',' i2=INTEGER ',' i3=INTEGER rest LINE_BREAK ...
 | ...
 ;

rest
 : ~LINE_BREAK*
 ;