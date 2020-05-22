class P implements Parser {

    @Inject
    public P(@Named("x") Parser x, @Named("y") Parser y) {
        // ...
    }

}