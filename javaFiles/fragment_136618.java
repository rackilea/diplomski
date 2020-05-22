B b = new B();
C c = new C();

b = (B) c; //invalid, won't compile

A b = b;
c = (C) b; //will compile, but cause a ClassCastException at runtime