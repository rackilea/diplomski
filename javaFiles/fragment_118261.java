Field[] declaredFields = Test.class.getDeclaredFields();
List<Field> staticFields = new ArrayList<Field>();
for (Field field : declaredFields) {
    if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
        staticFields.add(field);
    }
}