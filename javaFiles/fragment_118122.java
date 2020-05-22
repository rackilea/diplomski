A a = new A("a");  // A superclass
    B b = new B("b");  // B extends A
    C c = new C("c");  // C extends B
    D d = new D();     // not extending A

    Vehicle<A> vehicle = new Vehicle<>();
    vehicle.addPassenger(a);
    vehicle.addPassenger(b);
    vehicle.addPassenger(c);   // passenger of type A,B and C can be added
    vehicle.addPassenger(d);   // !ERROR: passenger of type D can't be added.