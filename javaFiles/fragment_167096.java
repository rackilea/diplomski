private static List<Field> findAllFields(Class<?> metaClass) {
    List<Field[]> fields = new ArrayList<Field[]>();
    findFields(metaClass, fields);

    List<Field> allFields = new ArrayList<Field>();
    for(Field[] f : fields) {
        List<Field> asList = Arrays.asList(f);
        allFields.addAll(asList);
    }
    return allFields;
}

private static void findFields(Class metaClass2, List<Field[]> fields) {
    Class next = metaClass2;
    while(true) {
        Field[] f = next.getDeclaredFields();
        fields.add(f);
        next = next.getSuperclass();
        if(next.equals(Object.class))
            return;
    }
}