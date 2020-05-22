start with: init

init ::= A:e | B:e;
A    ::= A:e | A:e -a- | EMPTY;
B    ::= B:e | B:e -b- | EMPTY;
a    ::= a:e {: RESULT = e:}
b    ::= b:e {: RESULT = e:}