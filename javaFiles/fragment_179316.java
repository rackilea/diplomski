public static <T> Vector<T> getVector(Class<T> clazz) {
  return new Vector<T>()
}

public static <T> Vector<T> getVector(T t) {
  Vector<T> vector = new Vector<T>();
  vector.add(t);
  return vector;
}