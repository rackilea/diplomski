@Override
public void resolve(SerializerProvider serializerProvider) throws JsonMappingException {
    if(defaultSerializer instanceof ResolvableSerializer) {
         ((ResolvableSerializer)defaultSerializer).resolve(serializerProvider);
    }
}