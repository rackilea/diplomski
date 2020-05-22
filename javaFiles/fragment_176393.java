A a = new A();
a.setSomething(1);
a.setSomethingElse(2);

B b = new B(a);
b.setAnotherThing(999);
b.setYetAnotherThing(888);

C c = new C(b);
assertTrue(c.isLargerThanTen());