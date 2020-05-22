protected static <E extends Enum<E>> void setEnumsArray(Class<E> ec, E... e) throws Exception {
    Field field = ec.getDeclaredField("ENUM$VALUES");
    Field modifiersField = Field.class.getDeclaredField("modifiers");
    field.setAccessible(true);
    modifiersField.setAccessible(true);
    modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
    field.set(ec, e);
  }