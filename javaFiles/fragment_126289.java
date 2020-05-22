Predicate<Call> uriEndsWithA = new Predicate<Call>() {
    @Override
    public boolean apply(final Call input) {
        return input.getUri().endsWith("a");
    }
};
whenHttp(server).match(custom(uriEndsWithA)).then(ok());