private static <E extends Enum> long ord(E e){
  return 1L<<e.ordinal();
}

static final long positiveSet = ord(E.A)+ord(E.B);
boolean f(int ordinal){
  return 0!=(positiveSet&(1L<<ordinal));
}