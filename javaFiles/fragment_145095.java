final class AlwaysListTypeAdapterFactory
        implements TypeAdapterFactory {

    private static final TypeAdapterFactory alwaysListTypeAdapterFactory = new AlwaysListTypeAdapterFactory();

    private AlwaysListTypeAdapterFactory() {
    }

    static TypeAdapterFactory getAlwaysListTypeAdapterFactory() {
        return alwaysListTypeAdapterFactory;
    }

    @Override
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken)
            throws IllegalArgumentException {
        if ( List.class.isAssignableFrom(typeToken.getRawType()) ) {
            final Type elementType = getElementType(typeToken);
            // Class<T> instances can be compared with ==
            final TypeAdapter<?> elementTypeAdapter = elementType == MyEntity.class ? gson.getAdapter(MyEntity.class) : null;
            // Found supported element type adapter?
            if ( elementTypeAdapter != null ) {
                @SuppressWarnings("unchecked")
                final TypeAdapter<T> castTypeAdapter = (TypeAdapter<T>) getAlwaysListTypeAdapter(elementTypeAdapter);
                return castTypeAdapter;
            }
        }
        // Not a type that can be handled? Let Gson pick a more appropriate one itself
        return null;
    }

    // Attempt to detect the list element type  
    private static Type getElementType(final TypeToken<?> typeToken) {
        final Type listType = typeToken.getType();
        return listType instanceof ParameterizedType
                ? ((ParameterizedType) listType).getActualTypeArguments()[0]
                : Object.class;
    }

}