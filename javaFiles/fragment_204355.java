interface A {...}
interface B {...}
class X extends A, B {...}

void f(X);
void f(A);
void f(B);

X x = ...
f(x); // calls f(X)
f((A)x); // calls f(A)
f((B)x); // calls f(B)