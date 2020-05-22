lexer grammar AnnotationLexer;

ANNOTATION_START
 : '/**' -> mode(INSIDE), skip
 ;

IGNORE
 : . -> skip
 ;

mode INSIDE;


KEY : '@' [a-zA-Z]+ ;


STRING: '"' (~'"' | ',')* '"' ;


ANNOTATION_END
 : '*/' -> mode(READ_JAVADOC), skip
 ;

IGNORE_INSIDE
 : [ \t\r\n] -> skip

mode READ_JAVADOC;

JAVADOC_START_AFTER_FIRST
 : '/**' skip
 ;

IGNORE_INSIDE_AFTER_FIRST
 : [ \t\r\n] -> skip
 ;

JAVADOC_END_AFTER_FIRST
 : '*/' skip
 ;