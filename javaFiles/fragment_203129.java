%module example

%inline %{
  // Wrap and pass through to example_wrap.c simultaneously
  extern int gcd(int x, int y);
  extern double Foo;  
%}