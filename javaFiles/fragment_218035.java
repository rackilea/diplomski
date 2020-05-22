lexer grammar AnnotationLexer;

ANNOTATION_START
 : '/**' -> mode(INSIDE), skip
 ;

IGNORE
 : . -> skip
 ;

mode INSIDE;

ID
 : '@' [A-Z] (~[(\r\n] | '\\)')*
 ;

VALUE
 : '(' ~[\r\n]*
 ;

ANNOTATION_END
 : '*/' -> mode(DEFAULT_MODE), skip
 ;

IGNORE_INSIDE
 : [ \t\r\n] -> skip
 ;