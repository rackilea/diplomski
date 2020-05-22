interface Method<T extends A> {
  public void invoke(T ref);
}

class MethodForA implements Method<A> {
  public void invoke(A ref) { .. }
}

class MethodMapper {
  Map<Class<?>, Method<? extends A>> mapping;

  MethodMapper() {
    mapping = new HashMap<Class<?>, Method<? extends A>>();
    mapping.put(A.class, new MethodForA());
  }

  void invoke(A object) {
    Method<? extends A> method = mapping.get(object.getClass());
    if (method != null) {
      method.invoke(object);
    }
  }