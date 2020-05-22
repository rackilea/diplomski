class A {
    public foo() {}
}

class B extends A {
    private foo() {}  // No!
}

class C extends A {
    foo() {}          // No! foo is package-visible, which is lower than public
}