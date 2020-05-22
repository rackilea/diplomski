Field[] declaredFields = Color.class.getDeclaredFields();
for (Field field : declaredFields) {
  if (Modifier.isStatic(field.getModifiers())) {
    System.out.println(field.getName() + ": " + field.getType());
  }
}