grammar dates;

options {  
  language = Java; 
  output = AST;
}                     

parse
    : '\n'* date ('\n'+ date)* '\n'* EOF
    ;

date 
  // start w/ a duration. Returned value will be a Joda Period object
  : year month? day? 
    {System.out.println(String.format("\%dy \%dm \%dd", $year.num, $month.num, $day.num));} 
  | month day?
    {System.out.println(String.format("0y \%dm \%dd", $month.num, $day.num));}
  | day
    {System.out.println(String.format("0y 0m \%dd", $day.num));}
  ;

year returns [int num]
    : INTEGER YEAR
        {$num = $INTEGER.int;}
    ;
month returns [int num]
    : INTEGER MONTH
        {$num = $INTEGER.int;}
    ;
day returns [int num]
    : INTEGER DAY
        {$num = $INTEGER.int;}
    ;
DAY : 'DAY' | 'DAYS'
    ;    
MONTH
    : 'MONTH' | 'MONTHS'
    ;    
YEAR: 'YEAR' | 'YEARS'
    ;    
INTEGER
    : '0' 
    | ('1'..'9')('0'..'9')*
    ;
WS
    : ('\t' | ' ' | '\r') {skip();}
    ;