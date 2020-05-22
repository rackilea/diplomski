grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals

generate myDsl "http://www.xtext.org/example/mydsl/MyDsl"

Model:
    greetings+=Greeting*;

Greeting:
    'Example' ':' comment=Comment;

Comment:
    (ID ('\r'? '\n')?)+ 
;