public static Object lookupStaticMember(String name) /* throws many */ {
  String classField[] = name.split("\\.");
  Class<?> klass = Class.forName(classField[0]);
  Field field = klass.getField(classField[1]);
  int mods = field.getModifiers();
  if ((Modifier.PUBLIC & mods == 0) || (Modifier.STATIC & mods == 0)) {
    throw new IllegalArgumentException("field " + name + " is not public static");
  }
  return field.get(klass);
}