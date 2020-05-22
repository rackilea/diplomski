public static final FieldType TYPE_STORED = new FieldType();
static {
    TYPE_STORED.setTokenized(true);
    TYPE_STORED.setOmitNorms(true);
    TYPE_STORED.setIndexOptions(IndexOptions.DOCS);
    TYPE_STORED.setNumericType(FieldType.NumericType.DOUBLE);
    TYPE_STORED.setStored(true);
    TYPE_STORED.freeze();
}