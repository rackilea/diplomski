parser grammar P;

statement returns[String first, String last]
 : WORD SCOL
   {
     $first = $WORD.text;
     $last = $SCOL.text;
   }
 ;