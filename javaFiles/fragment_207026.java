public static <X, T extends Enum<T> & Fields<?, ?, List<X>>>
List<EnumMap<T, List<X>>> getEntries(InputStream is, Class<T> fields) throws IOException {
    final List<List<Byte>> entries = new ArrayList<List<Byte>>();
    // populate "entries"

    FieldsStrategy<X, T> strategy = selectStrategy(fields);
    return strategy.getEntries(entries);
}

private static <X, T extends Enum<T> & Fields<?, ?, List<X>>>
FieldsStrategy<X, T> selectStrategy(Class<T> fields) {
    final boolean hasLists = hasLists(fields);
    return hasLists
            ? (FieldsStrategy<X, T>) new ByteListFieldsStrategy(fields) //* this is the only unchecked warning
            : (FieldsStrategy<X, T>) new ByteFieldsStrategy(fields);    //* this is the only unchecked warning
}

private abstract static class FieldsStrategy<X, T extends Enum<T> & Fields<?, ?, List<X>>> {
    private Class<T> fields;

    public FieldsStrategy(Class<T> fields) {
        this.fields = fields;
    }

    public List<EnumMap<T, List<X>>> getEntries(List<List<Byte>> entries) {

        List<EnumMap<T, List<X>>> daBytes = new ArrayList<EnumMap<T, List<X>>>();
        final int numOfEntries = entries.size();
        for (int currentEntry = 0; currentEntry < numOfEntries; ++currentEntry) {
            // add an element in daBytes for this currentEntry
            daBytes.add(new EnumMap<T, List<X>>(fields));
            for (T daField : fields.getEnumConstants()) {
                EnumMap<T, List<X>> map = daBytes.get(currentEntry);
                map.put(daField, getFieldData(daField));
            }
        }
        return daBytes;
    }

    protected abstract List<X> getFieldData(T daField);

}

public static class ByteFieldsStrategy<T extends Enum<T> & Fields<?, ?, List<Byte>>>
        extends FieldsStrategy<Byte, T> {
    public ByteFieldsStrategy(Class<T> fields) {
        super(fields);
    }

    protected List<Byte> getFieldData(T daField) {
        ArrayList<Byte> field = new ArrayList<Byte>();
        // populate "field"
        return field;
    }
}

public static class ByteListFieldsStrategy<T extends Enum<T> & Fields<?, ?, List<List<Byte>>>>
        extends FieldsStrategy<List<Byte>, T> {
    public ByteListFieldsStrategy(Class<T> fields) {
        super(fields);
    }

    protected List<List<Byte>> getFieldData(T daField) {
        List<List<Byte>> fieldEntries = new ArrayList<List<Byte>>();
        // populate "fieldEntries"
        return fieldEntries;
    }
}