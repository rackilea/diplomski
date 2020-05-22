public GenericClass(Class<T> objectClass) {
  try {
    myObject = objectClass.newInstance();

  } catch (InstantiationException e) {
    e.printStackTrace();
  } catch (IllegalAccessException e) {
    e.printStackTrace();
  }
}