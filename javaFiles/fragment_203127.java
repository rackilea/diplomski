%module example

%{
// code here is passed straight to example_wrap.c unmodified
extern int gcd(int x, int y);
extern double Foo;
%}

// code here is wrapped:
extern int gcd(int x, int y);
extern double Foo;