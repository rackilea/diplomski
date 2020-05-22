for (Field field : clazz.getDeclaredFields()) {
  if (field.getName().equals("id")) {
    // Do whatever.
    break;
  }
}