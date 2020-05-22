class Bar extends Foo {
    public Bar(double init_x) throws Exception {
        super(init_x);
        if (init_x < 10) {
            throw new Exception();
        }
    }
}