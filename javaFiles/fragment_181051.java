public enum Types {
  SMALL(1), SMALL2(2), SMALL3(3),

  BIG(0), BIG1(1), BIG2(2), BIG3(3), BIG4(4);

  static final ImmutableTable<Integer, Integer, Types> TABLE =
    ImmutableTable.<Integer, Integer, Types>builder()
      .put(Size.XL.getValue(), BIG.getValue(), BIG)
      .put(Size.XL.getValue(), BIG2.getValue(), BIG2)
      .put(Size.XL.getValue(), BIG4.getValue(), BIG4)
      .put(Size.LARGE.getValue(), BIG4.getValue(), BIG4)
      .put(Size.LARGE.getValue(), SMALL2.getValue(), SMALL2)
      .put(Size.LARGE.getValue(), SMALL3.getValue(), SMALL3)
      .put(Size.UNKNOWN.getValue(), BIG.getValue(), BIG)
      .put(Size.UNKNOWN.getValue(), BIG1.getValue(), BIG1)
      .put(Size.UNKNOWN.getValue(), BIG4.getValue(), BIG4)
      .build();

  private final int id;

  Types(int id) {
    this.id = id;
  }

  public int getValue() {
    return id;
  }

  public static Collection<Types> getTypesWithSize(Size size) {
    return TABLE.row(size.getValue()).values();
  }

  public static Collection<Types> getTypesWithId(Types types) {
    return TABLE.column(types.getValue()).values();
  }

  public static <T> Types parseType(T type, int id) {
    final int intType = Integer.parseInt(String.valueOf(type));

    if (!TABLE.contains(intType, id)) {
      // return some default value or throw exception
    }
    return TABLE.get(intType, id);
  }
}