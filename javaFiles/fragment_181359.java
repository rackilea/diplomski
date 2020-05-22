class CompressedPropertyNamingStrategy extends PropertyNamingStrategy {

    private static final long serialVersionUID = 1L;

    @Override
    public String nameForGetterMethod(MapperConfig<?> config, AnnotatedMethod method,
            String defaultName) {
        CompressedName compressedProperty = method.getAnnotation(CompressedName.class);
        if (compressedProperty != null) {
            return compressedProperty.value();
        }

        // Implement default value: first letter, or something else
        return defaultName;
    }
}