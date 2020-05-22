final Function1<Integer, String> f = new Function1<Integer, String>() {
    public int $tag() {
        return Function1$class.$tag(this);
    }

    public <A> Function1<A, String> compose(Function1<A, Integer> f) {
        return Function1$class.compose(this, f);
    }

    public String apply(Integer someInt) {
        return myFunc(someInt);
    }
};
MyScala.setFunc(f);