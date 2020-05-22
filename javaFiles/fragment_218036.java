parser grammar AnnotationParser;

options {
  tokenVocab=AnnotationLexer;
}

parse
 : pair* EOF
 ;

pair
 : ID VALUE {System.out.println("ID=" + $ID.text + ", VALUE=" + $VALUE.text);}
 ;