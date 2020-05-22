public class CollectionCountBridge implements MetadataProvidingFieldBridge {
    private static final String COUNT_SUFFIX = "_count";

    @Override
    public void configureFieldMetadata(String name, FieldMetadataBuilder builder) {
        builder.field(name + COUNT_SUFFIX, FieldType.INTEGER).sortable(true);
    }

    @Override
    public void set(String name, Object object, Document document, LuceneOptions luceneOptions) {
        if (object == null || (!(object instanceof Collection))) {
            return;
        }
        Collection<?> coll = (Collection<?>) object;
        int size = coll.size();

        luceneOptions.addNumericFieldToDocument(name + COUNT_SUFFIX, size, document);
        document.add(new NumericDocValuesField(name + COUNT_SUFFIX, size.longValue()));
    }
}