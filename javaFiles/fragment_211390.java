FooGen<Number, Number> foogen = new FooGen<Number, Number>() {
    @Override
    Number fnN(Number... gs) {
        return super.fnN(gs);
    }
};
System.out.println(foogen.fn2(1.2, 3.4));