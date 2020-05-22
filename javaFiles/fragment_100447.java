final class ApiResponseTypeAdapterFactory
        implements TypeAdapterFactory {

    // No state, so it can be instantiated once
    private static final TypeAdapterFactory apiResponseTypeAdapterFactory = new ApiResponseTypeAdapterFactory();

    // Type tokens are effective value types and can be instantiated once per parameterization
    private static final TypeToken<List<ApiResponseError>> apiResponseErrorsType = new TypeToken<List<ApiResponseError>>() {
    };

    private ApiResponseTypeAdapterFactory() {
    }

    static TypeAdapterFactory getApiResponseTypeAdapterFactory() {
        return apiResponseTypeAdapterFactory;
    }

    @Override
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
        // Is it ApiResponse, a class we can handle?
        if ( ApiResponse.class.isAssignableFrom(typeToken.getRawType()) ) {
            // Trying to resolve its parameterization
            final Type typeParameter = getTypeParameter0(typeToken.getType());
            // And asking Gson for the success and failure type adapters to use downstream parsers
            final TypeAdapter<?> successTypeAdapter = gson.getDelegateAdapter(this, TypeToken.get(typeParameter));
            final TypeAdapter<List<ApiResponseError>> failureTypeAdapter = gson.getDelegateAdapter(this, apiResponseErrorsType);
            @SuppressWarnings("unchecked")
            final TypeAdapter<T> castTypeAdapter = (TypeAdapter<T>) new ApiResponseTypeAdapter<>(successTypeAdapter, failureTypeAdapter);
            return castTypeAdapter;
        }
        return null;
    }

    private static Type getTypeParameter0(final Type type) {
        // Is this type parameterized?
        if ( !(type instanceof ParameterizedType) ) {
            // No, it's raw
            return Object.class;
        }
        final ParameterizedType parameterizedType = (ParameterizedType) type;
        return parameterizedType.getActualTypeArguments()[0];
    }

    private static final class ApiResponseTypeAdapter<T>
            extends TypeAdapter<ApiResponse<T>> {

        private final TypeAdapter<T> successTypeAdapter;
        private final TypeAdapter<List<ApiResponseError>> failureTypeAdapter;

        private ApiResponseTypeAdapter(final TypeAdapter<T> successTypeAdapter, final TypeAdapter<List<ApiResponseError>> failureTypeAdapter) {
            this.successTypeAdapter = successTypeAdapter;
            this.failureTypeAdapter = failureTypeAdapter;
        }

        @Override
        public void write(final JsonWriter out, final ApiResponse<T> value)
                throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }

        @Override
        public ApiResponse<T> read(final JsonReader in)
                throws IOException {
            final JsonToken token = in.peek();
            switch ( token ) {
            case BEGIN_ARRAY:
                // Is it array? Assuming that the responses come as arrays only
                // Otherwise a more complex parsing is required probably replaced with JsonDeserializer for some cases
                // So reading the next value (entire array) and wrapping it up in an API response with the success-on state
                return success(successTypeAdapter.read(in));
            case BEGIN_OBJECT:
                // Otherwise it's probably an error object?
                in.beginObject();
                final String name = in.nextName();
                if ( !name.equals("errors") ) {
                    // Let it fail fast, what if a successful response would be here?
                    throw new MalformedJsonException("Expected errors` but was " + name);
                }
                // Constructing a failed response object and terminating the error object
                final ApiResponse<T> failure = failure(failureTypeAdapter.read(in));
                in.endObject();
                return failure;
            // A matter of style, but just to show the intention explicitly and make IntelliJ IDEA "switch on enums with missing case" to not report warnings here
            case END_ARRAY:
            case END_OBJECT:
            case NAME:
            case STRING:
            case NUMBER:
            case BOOLEAN:
            case NULL:
            case END_DOCUMENT:
                throw new MalformedJsonException("Unexpected token: " + token);
            default:
                throw new AssertionError(token);
            }
        }

    }

}