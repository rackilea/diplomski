class Bar extends Foo {
    private static double checkInitX(double init_x) throws Exception {
        if (init_x < 10) {
            throw new Exception();
        }
        return init_x;
    }

    public Bar(double init_x) throws Exception {
        super(checkInitX(init_x));
    }
}