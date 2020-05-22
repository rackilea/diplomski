final class NoKeysTypeAdapterFactory
        implements TypeAdapterFactory {

    // No accessible constructor needed - Gson can instantiate it itself
    private NoKeysTypeAdapterFactory() {
    }

    @Override
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
        // Is it a list?
        if ( List.class.isAssignableFrom(typeToken.getRawType()) ) {
            // Try to determine the list element type
            final Type elementType = getElementType(typeToken.getType());
            // And create a custom type adapter instance bound to the specific list type
            @SuppressWarnings("unchecked")
            final TypeAdapter<T> typeAdapter = (TypeAdapter<T>) getNoKeysTypeAdapter(gson, elementType);
            return typeAdapter;
        }
        // Otherwise just tell Gson try to find another appropriate parser
        return null;
    }

    private static Type getElementType(final Type type) {
        // Is it a generic type with type parameters?
        if ( type instanceof ParameterizedType ) {
            final ParameterizedType parameterizedType = (ParameterizedType) type;
            // If yes, then just take the first type argument since java.util.List can only one type
            return parameterizedType.getActualTypeArguments()[0];
        }
        // Otherwise java.lang.Object due to either Java generics type erasure or raw types usage
        return Object.class;
    }

}