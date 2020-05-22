public static void main(String[] args) {
  Person p = new Person();
  Supplier<String> nameSupplier1 = () -> "MyName";
  Supplier<String> nameSupplier2 = () -> { throw new RuntimeException(); };
  set(p, Person::setName, nameSupplier1);
  System.out.println(p.getName()); // prints MyName
  set(p, Person::setName, nameSupplier2); // throws exception with message
  System.out.println(p.getName()); // Does not execute
}

interface DebuggableBiConsumer<A, B> extends BiConsumer<A, B>, Serializable {}

private static <E, V> void set(
    E o, DebuggableBiConsumer<E, V> setter, Supplier<V> valueSupplier) {
  try {
    setter.accept(o, valueSupplier.get());
  } catch (RuntimeException e) {
    throw new RuntimeException("Failed to set the value of "+name(setter), e);
  }
}

private static String name(DebuggableBiConsumer<?, ?> setter) {
  for (Class<?> cl = setter.getClass(); cl != null; cl = cl.getSuperclass()) {
    try {
      Method m = cl.getDeclaredMethod("writeReplace");
      m.setAccessible(true);
      Object replacement = m.invoke(setter);
      if(!(replacement instanceof SerializedLambda))
        break;// custom interface implementation
      SerializedLambda l = (SerializedLambda) replacement;
      return l.getImplClass() + "::" + l.getImplMethodName();
    }
    catch (NoSuchMethodException e) {}
    catch (IllegalAccessException | InvocationTargetException e) {
      break;
    }
  }
  return "unknown property";
}