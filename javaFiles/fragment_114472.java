class SuperClass {
    public void method () {
        // We try to cast and NARROW the type to a
        // specific "view". This can fail which is one
        // reason why it's not usually appropriate.
        ((IClass)this).implementedMethod();
    }
}

class SubClass extends SuperClass implements IClass {
  // ..
}

class BrokenSubClass extends SuperClass () {
}

// OK! Although it is the SAME OBJECT, the SuperClass
// method can "view" the current instance (this) as an IClass
// because SubClass implements IClass. This view must be
// explicitly request through a cast because SuperClass itself
// does not implement IClass or have a suitable method to override.
(new SubClass()).method();

// BAD! ClassCastException, BrokenSubClass cannot be "viewed" as IClass!
// But we didn't know until runtime due to lost type-safety.
(new BrokenSubClass()).method();