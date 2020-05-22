INTEGER
 : (DATE_PERIOD_CONSTANT)=> DATE_PERIOD_CONSTANT ((' '+ DATE_PERIOD_CONSTANT)=> ' '+ DATE_PERIOD_CONSTANT)*
   {
     $type=DATE_PERIOD_CONSTANT;
   }
 | DIGIT+
   {
     if ($text.matches("(19|20|21)[0-9]{2}[0-1]\\d{3}")) {
       System.out.println("Matched date pattern");
       $type = DATE;
     }
   }   
 ;

fragment DATE_PERIOD_CONSTANT
 : DIGIT+ ' '+ (YEAR | MONTH | WEEK | DAY)
 ;