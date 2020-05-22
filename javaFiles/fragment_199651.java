A a = new A();
B b = new B();
C c = new C();
a.c = c;
b.c = c;

out.writeObject(a); // writes a and c
out.writeObject(b); // writes b and the handle to c