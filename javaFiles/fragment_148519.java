class Test<T extends InterfaceA & InterfaceB> {
    T object;

    Test() {
        object.a();
        object.b();
    }

}