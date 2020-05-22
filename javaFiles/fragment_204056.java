interface Service<T extends BaseType, Q extends Query<T>> {
    public Result<T> get(Q query);
}

class SomeService implements Service<TypeA, SomeQuery> {

    @Override
    public SomeResult get(SomeQuery query) {
        ...
    }
}