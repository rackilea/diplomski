public static void main(String args[]) {
  Class<Foo> c = Foo.class;
  for (Field f : c.getDeclaredFields()) {
    int mod = f.getModifiers();
    if (Modifier.isStatic(mod) && Modifier.isPublic(mod) && Modifier.isFinal(mod)) {
      try {
        System.out.printf("%s = %d%n", f.getName(), f.get(null));
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      }
    }
  }
}