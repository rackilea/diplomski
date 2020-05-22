INTEGER
 : DIGIT+ ( (' '+ (YEAR | MONTH | WEEK | DAY))=> 
             ' '+ (YEAR | MONTH | WEEK | DAY) {$type = DATE_PERIOD_CONSTANT;}
          )?
   {
     if ($text.matches("(19|20|21)[0-9]{2}[0-1]\\d{3}")) {
       $type = DATE;
     }
   }

 ;

fragment DATE_PERIOD_CONSTANT : ;