final String[] fields = new String[]{ "field1", "field2", "field3" };
final float[] scalars = new float[]{ 0.5f, 1.4f, 1.8f };

Sort sort = new Sort(
    new SortField(
        "",
        new FieldComparatorSource() {
            public FieldComparator newComparator(String fieldname, int numHits, int sortPos, boolean reversed) throws IOException {
                return new ScaledComparator(numHits, fields, scalars);
            }
        }
    )
);