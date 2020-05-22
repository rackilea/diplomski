interface Service<T extends BaseType, Q extends Query<T>, R extends Result<T>> {
    public R get(Q query);
}

class SomeService implements Service<TypeA, SomeQuery, SomeResult> {

    @Override
    public SomeResult get(SomeQuery query) {
        ...
    }
}