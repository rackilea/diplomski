class MyModule<T> extends AbstractModule {
    public MyModule(TypeLiteral<T> type) {
        _type = type;
    }

    @Override protected void configure() {
        TypeLiteral<A<T>> a = newGenericType(A.class);
        TypeLiteral<AImpl<T>> aimpl = newGenericType(AImpl.class);
        bind(a).to(aimpl);
        TypeLiteral<B<T>> b = newGenericType(B.class);
        TypeLiteral<BImpl<T>> bimpl = newGenericType(BImpl.class);
        bind(b).to(bimpl);
    }

    @SuppressWarnings("unchecked")
    private <V> TypeLiteral<V> newGenericType(Class<?> base) {
        Type newType = Types.newParameterizedType(base, _type.getType());
        return (TypeLiteral<V>) TypeLiteral.get(newType);
    }

    final private TypeLiteral<T> _type;
}