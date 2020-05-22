grammar Question;

/* extract digit */

question
    :   tpin EOF
    ;

tpin
//  :   PREFIX EXTRA? DIGIT+ SUFFIX?
//      {System.out.println("The only useful information is " + $DIGIT.text);}
    :   PREFIX EXTRA? number SUFFIX?
        {System.out.println("The only useful information is " + $number.text);}
    ;

number
    :   DIGIT+
    ;

PREFIX  : [abcd]'_'; 
EXTRA   : ('xyz' | 'XYZ' );
DIGIT   : [0-9] ;
SUFFIX  : [ab];
WS      : [ \t\r\n]+ -> skip ;