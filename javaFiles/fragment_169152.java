//each line can have one to many amprstmt's
line
   : (linenumber ((amprstmt (COLON amprstmt?)*) | (COMMENT | REM)))
   ;

amprstmt
   : (amperoper? statement) //encounters a statement here
   | (COMMENT | REM)
   ;
//statements can be made of 1 to many sub statements
statement
   : (CLS | LOAD | SAVE | TRACE | NOTRACE | FLASH | INVERSE | GR | NORMAL | SHLOAD | CLEAR | RUN | STOP | TEXT | HOME | HGR | HGR2)
   | prstmt
   | printstmt1 //the print rule
   //MANY MANY OTHER RULES HERE TOO LONG TO PASTE........
   ;
//the example rule that occurs when the token's "print" is encountered
printstmt1
   : (PRINT | QUESTION) printlist?
   ;

printlist
   : expression (COMMA | SEMICOLON)? printlist*
   ;