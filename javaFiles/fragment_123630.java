int i = 0;
do while ( ++i < 1 ) { //DO NOT COMPILE,Syntax error, insert "while ( Expression ) ;" to complete DoStatement
      System.out.print("i is " + i);
}

do while ( ++i < 1 )  // DO NOT COMPILE,Syntax error, insert "while ( Expression ) ;" to complete DoStatement
      System.out.print("i is " + i);

while ( i > 1 ) {} //COMPILE
do while ( i > 1 ) {} //DO NOT COMPILE,Syntax error, insert "while ( Expression ) ;" to complete DoStatement