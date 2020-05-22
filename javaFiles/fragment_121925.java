public class DocumentTypeResolver extends StdTypeResolverBuilder {
    @Override
    public TypeDeserializer buildTypeDeserializer(
            final DeserializationConfig config, final JavaType baseType, final Collection<NamedType> subtypes) {
        return new DocumentDeserializer(baseType, null,
                _typeProperty, _typeIdVisible, _defaultImpl);
    }
}