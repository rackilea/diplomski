class Holder<SomeType extends AbstractType>{
    private final Function<String, SomeType> cons;

    public Holder(Function<String, SomeType> cons) {
        this.cons = cons;
        ...
    }

    SomeType createType() {
        return cons.apply("SomeString");
    }
}