@SuppressWarnings("unchecked")
final TypeToken<List<?>> listTypeToken = (TypeToken<List<?>>) TypeToken.get(new ParameterizedType() {
    @Override
    public Type getRawType() {
        return List.class;
    }

    @Override
    public Type[] getActualTypeArguments() {
        return new Type[]{ listElementType };
    }

    @Override
    public Type getOwnerType() {
        return null;
    }
});