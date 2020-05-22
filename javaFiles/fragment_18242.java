protected static Field getEnumsArrayField(Class<?> ec) throws Exception {
    Field field = ec.getDeclaredField("ENUM$VALUES");
    field.setAccessible(true);
    return field;
  }

  protected static void clearFieldAccessors(Field field) throws ReflectiveOperationException {
    Field fa = Field.class.getDeclaredField("fieldAccessor");
    fa.setAccessible(true);
    fa.set(field, null);

    Field ofa = Field.class.getDeclaredField("overrideFieldAccessor");
    ofa.setAccessible(true);
    ofa.set(field, null);

    Field rf = Field.class.getDeclaredField("root");
    rf.setAccessible(true);
    Field root = (Field) rf.get(field);
    if (root != null) {
      clearFieldAccessors(root);
    }