private static final FieldType DOUBLE_FIELD_TYPE_STORED_SORTED = new FieldType();
static {
    DOUBLE_FIELD_TYPE_STORED_SORTED.setTokenized(true);
    DOUBLE_FIELD_TYPE_STORED_SORTED.setOmitNorms(true);
    DOUBLE_FIELD_TYPE_STORED_SORTED.setIndexOptions(IndexOptions.DOCS);
    DOUBLE_FIELD_TYPE_STORED_SORTED
        .setNumericType(FieldType.NumericType.DOUBLE);
    DOUBLE_FIELD_TYPE_STORED_SORTED.setStored(true);
    DOUBLE_FIELD_TYPE_STORED_SORTED.setDocValuesType(DocValuesType.NUMERIC);
    DOUBLE_FIELD_TYPE_STORED_SORTED.freeze();
}