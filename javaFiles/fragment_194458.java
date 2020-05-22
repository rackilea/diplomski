@SuppressWarnings("unchecked")
public static <T> Field<T> elementAt(Field<T[]> arrayField, int index) {
    return DSL.field("{0}[{1}]", 
        (Class<T>) arrayField.getType().getComponentType(),
        arrayField, DSL.inline(index)
    );
}