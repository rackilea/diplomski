class ValidatingSerializer extends JsonSerializer<Object> {
    private final JsonSerializer<Object> defaultSerializer;
    private final Validator validator;

    ValidatingSerializer(final JsonSerializer<Object> defaultSerializer) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
        this.defaultSerializer = defaultSerializer;
    }

    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider provider)
            throws IOException {
        if (!validator.validate(value).isEmpty()) {
            throw new IOException("Null value encountered");
        }
        defaultSerializer.serialize(value, gen, provider);
    }
}