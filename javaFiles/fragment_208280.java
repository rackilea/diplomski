grammar WKT;

parse
 : polygon EOF
 ;

polygon
 : POLYGON '(' ( points ( ',' points )* )? ')'
 ;

points
 : '(' ( value value ( ',' value value )* )? ')'
 ;

value
 : INT
 | FLOAT
 | DATE_TIME
 ;

POLYGON
 : [pP] [oO] [lL] [yY] [gG] [oO] [nN]
 ;

INT
 : DIGITS
 ;

FLOAT
 : DIGITS '.' DIGITS
 ;

DATE_TIME
 : D D D D '-' D D '-' D D 'T' D D ':' D D ':' D D [+-] D D ':' D D
 | D D D D '-' D D '-' D D 'T' D D ':' D D ':' D D 'Z'
 | D D D D D D D D 'T' D D D D D D 'Z'
 ;

SPACES
 : [ \t\r\n]+ -> skip
 ;

fragment DIGITS
 : D+
 ;

fragment D
 : [0-9]
 ;