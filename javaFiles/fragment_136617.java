C c = new C();
B b = new B();
c.methodFromA(); //C inherits methods from A by being its child
b.methodFromA(); //B inherits methods from A by being its child

c.methodFromB(); //not allowed
b.methodFromC(); //not allowed