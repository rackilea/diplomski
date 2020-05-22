lexer grammar TestLexer;

// Normal mode

PROPERTY : 'property';
EQUALS : '=';
ATR : [a-zA-Z]+;                           // match lower and upper-case identifiers name
STRING: '"' .*? '"';                       // match any string
WS : [ \t\r\n]+        -> skip;            // skip spaces, tabs, newlines
EOL : ';'              -> pushMode(NOISE); // when ';' is found, go to noise mode where everything is skip

mode NOISE;

NOISE_PROPERTY : 'property' -> type(PROPERTY), popMode;   // when 'property' is found, we say it's a PROPERTY token and we go back to  normal mode
ALL :  .+?                  -> skip;                      // skip all other stuffs