Animal a = new Animal();
Animal b = new Cat();
Animal c = new Cat();
Animal d = null;

a.foo(); // prints Animal
b.foo(); // prints Cat
c.foo(); // prints Cat
d.foo(): // throws NullPointerException