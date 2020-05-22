public static Method onlyMethod(Class c) {
  return Arrays.stream(c.getDeclaredMethods())
    .filter(m -> !m.isSynthetic())
    .reduce((a, b) -> {
        throw new IllegalStateException("More than one method declared.");
    })
    .get();
}