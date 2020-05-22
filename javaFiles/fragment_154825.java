tpin
    :   PREFIX EXTRA? INT SUFFIX?
        {System.out.println("The only useful information is " + $INT.text);}
    ;

PREFIX  : [abcd]'_'; 
EXTRA   : ('xyz' | 'XYZ' );
INT     : [0-9]+ ;
SUFFIX  : [ab];
WS      : [ \t\r\n]+ -> skip ;

$ grun Question question -tokens data.txt
[@0,0:1='d_',<PREFIX>,1:0]
[@1,2:4='xyz',<EXTRA>,1:2]
[@2,5:10='123456',<INT>,1:5]
[@3,11:11='b',<SUFFIX>,1:11]
[@4,13:12='<EOF>',<EOF>,2:0]
The only useful information is 123456