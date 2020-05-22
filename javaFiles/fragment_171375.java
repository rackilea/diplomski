List<Field> privateFields = new ArrayList<>();
Field[] allFields = SomeClass.class.getDeclaredFields();
for (Field field : allFields) {
    if (Modifier.isPrivate(field.getModifiers())) {
        privateFields.add(field);
    }
}