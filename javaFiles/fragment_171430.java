public void doSomething ()
{
    Map<A, ? super A> p = new HashMap<A, A>();

    A a1 = new A();
    A a2 = new A();

    // AS A CONSUMER
    // Not a problem because at runtime we'll know we can accept A.
    p.put(a1, new B());
    p.put(a2, new C());

    // AS A PRODUCER
    // what do I cast to? No way of knowing if its B or C.
    for (Object a : p.values())
    {
    }

    // Same deal as above is it B or C?
    p.get(a1);
}

class A{}

class B extends A {}

class C extends B {}