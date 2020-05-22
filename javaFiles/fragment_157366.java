public class UniqueCollectionDeserializer extends CollectionDeserializer {
    public UniqueCollectionDeserializer(
        JavaType collectionType,
        JsonDeserializer<Object> valueDeser,
        TypeDeserializer valueTypeDeser,
        ValueInstantiator valueInstantiator
    ) {
        super(collectionType, valueDeser, valueTypeDeser, valueInstantiator);
    }

    protected UniqueCollectionDeserializer(
        JavaType collectionType,
        JsonDeserializer<Object> valueDeser,
        TypeDeserializer valueTypeDeser,
        ValueInstantiator valueInstantiator,
        JsonDeserializer<Object> delegateDeser,
        NullValueProvider nuller,
        Boolean unwrapSingle
    ) {
        super(collectionType, valueDeser, valueTypeDeser, valueInstantiator, delegateDeser, nuller, unwrapSingle);
    }

    public UniqueCollectionDeserializer(CollectionDeserializer defaultDeserializer) {
        super(defaultDeserializer);
    }

    @Override
    public Collection<Object> deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException, JsonProcessingException {
        return removeDuplicates(super.deserialize(jsonParser, context));
    }

    @Override
    public Collection<Object> deserialize(JsonParser p, DeserializationContext ctxt, Collection<Object> result) throws IOException {
        return removeDuplicates(super.deserialize(p, ctxt, result));
    }

    @SuppressWarnings("unchecked")
    @Override
    protected CollectionDeserializer withResolved(
        JsonDeserializer<?> dd,
        JsonDeserializer<?> vd,
        TypeDeserializer vtd,
        NullValueProvider nuller,
        Boolean unwrapSingle
    ) {
        return new UniqueCollectionDeserializer(_containerType, (JsonDeserializer<Object>) vd, vtd, _valueInstantiator, (JsonDeserializer<Object>) dd, nuller, unwrapSingle);
    }

    private Collection<Object> removeDuplicates(Collection<Object> data) {
        return data.stream()
                .distinct()
                .collect(Collectors.toList());
    }
}