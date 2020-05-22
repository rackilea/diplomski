private Field searchFields(Field[] fields, String name) {
    String internedName = name.intern();
    for (int i = 0; i < fields.length; i++) {
        if (fields[i].getName() == internedName) {
            return getReflectionFactory().copyField(fields[i]);
        }
    }
    return null;
}