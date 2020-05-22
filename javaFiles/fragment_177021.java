private <T> static void ValueToField(Object value, DBField<T> field) {
    field.setValue((T)value);
}

//...
ValueToField(values.get(i), fields.get(i));