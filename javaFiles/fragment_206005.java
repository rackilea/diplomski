@Override
public Object get(String fieldName) {
    MyField field = MyField.mapNameToField(fieldName);
    if (field == null)
        throw new UnsupportedOperationException(); // Or could simply return null
    return field.getValue(this);
}