String root = s.replaceAll("^(.*?)(\\d+)$", "$1");
String number = s.replaceAll("^(.*?)(\\d+)$", "$2");

^(.*?)(\\d+)$
^ = begin of string
$ = end of string
.*? = shortest sequence of any character
\d+ = digit, one or more
( ... ) = group numbered from 1, $1, $2, ...