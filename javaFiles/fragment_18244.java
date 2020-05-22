protected static Singleton createEnumValue(String name, int ordinal, String description) throws Exception {
    Class<Singleton> monsterClass = Singleton.class;
    Constructor<?> constructor = monsterClass.getDeclaredConstructors()[0];
    constructor.setAccessible(true);

    Field constructorAccessorField = Constructor.class.getDeclaredField("constructorAccessor");
    constructorAccessorField.setAccessible(true);
    sun.reflect.ConstructorAccessor ca = (sun.reflect.ConstructorAccessor) constructorAccessorField.get(constructor);
    if (ca == null) {
      Method acquireConstructorAccessorMethod = Constructor.class.getDeclaredMethod("acquireConstructorAccessor");
      acquireConstructorAccessorMethod.setAccessible(true);
      ca = (sun.reflect.ConstructorAccessor) acquireConstructorAccessorMethod.invoke(constructor);
    }
    Singleton enumValue = (Singleton) ca.newInstance(new Object[] { name, ordinal, description });
    return enumValue;
  }

 protected static <E extends Enum<E>> void setFinalField(Class<E> ec, Field field, E e) throws NoSuchFieldException, IllegalAccessException {
    Field modifiersField = Field.class.getDeclaredField("modifiers");
    field.setAccessible(true);
    modifiersField.setAccessible(true);
    modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
    field.set(ec, e);
  }