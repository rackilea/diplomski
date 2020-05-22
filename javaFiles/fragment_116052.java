interface Thing {
    public void doThing();
}

class Test1 implements Thing {
    public void doThing() {
        // specific Test1 behavior
    }
}

class Test2 implements Thing {
    public void doThing() {
        // specific Test2 behavior
    }
}

class MyClass {

    Thing _thing;

    public void doSomething() {
        _thing.doThing();    // a proper polymorphism will take care of the dispatch,
                             // effectively eliminating usage of `instanceof`
    }
}