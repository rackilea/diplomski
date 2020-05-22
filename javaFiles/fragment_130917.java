class A extends D {
    ...
}

class D {
    //Can't mock this.
    final Object getObj() { ... }
}