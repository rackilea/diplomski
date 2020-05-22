@Provider
public static class OptionalParamProvider implements ParamConverterProvider {

    @Override
    public <T> ParamConverter<T> getConverter(Class<T> rawType, 
                                              Type genericType, 
                                              Annotation[] annotations) {
        if (Optional.class != rawType) {
            return null;
        }

        return (ParamConverter<T>)new ParamConverter<Optional>() {

            @Override
            public Optional fromString(String value) {
                return Optional.ofNullable(value);
            }

            @Override
            public String toString(Optional value) {
                return value.toString();
            }  
        };
    }  
}