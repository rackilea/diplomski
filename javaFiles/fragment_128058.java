class C1 {
  Object o;
}
class C2 implements Cloneable {
  C1 c1;
}

... main ... {
  C2 c2 = new C2();
  c2.c1 = new C1();
  c2.c1.o = new Object();
  C2 c2clone = c2.clone();
  System.out.println(c2 == c2clone); // prints false
  System.out.println(c2.c1 == c2clone.c1); // prints true
  c2.c1.o = new Object(); // modified both c2 and c2clone!!!