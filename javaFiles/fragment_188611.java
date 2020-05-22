class Foo {
    static enum MyEnum { A }

    void foo() {
        switch ( MyEnum.A ) { case A: }
    }
}