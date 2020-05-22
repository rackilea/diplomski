public Foo[] createObjects(boolean displayAll) {
    Foo foo = new Foo (x, y, z);
    Foo otherFoo = new Foo(z, y, x);
    return displayAll ? 
                new Foo[] {foo, otherFoo } :
                new Foo[] {foo} ;
}