Box<A> box = someClass.new Box<>();

A a1 = box.aMethod(b);
A a2 = box.aMethod(c);

B b1 = (B) a1;
B b2 = (B) a2;