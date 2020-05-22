enum Item {
  ONE(A.class),
  TWO(B.class);

  private final Class<?> clazz;
  private Item(Class<?> clazz) { this.clazz = clazz; }
  Class<?> getClazz() { return clazz; }
}