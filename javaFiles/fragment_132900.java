C c = new C();
A a = c;
B b = c;
System.out.println(a.i); // 5 - variable declared in A
System.out.println(b.i); // 6 - variable declared in B
System.out.println(c.i); // 7 - variable declared in C