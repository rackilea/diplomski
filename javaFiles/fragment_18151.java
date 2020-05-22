grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.xbase.Xbase

generate myDsl "http://www.xtext.org/example/mydsl/MyDsl"

Model:
    "model" name=ID "{"
        expressions+=NamedExpression*
    "}"
;

NamedExpression:
    name=ID "=" body=XExpression
;