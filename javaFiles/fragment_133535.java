public enum Letter {
  A,
  B,
  C,
  //...

  private static final List<Letter> VALUES =
    Collections.unmodifiableList(Arrays.asList(values()));
  private static final int SIZE = VALUES.size();
  private static final Random RANDOM = new Random();

  public static Letter randomLetter()  {
    return VALUES.get(RANDOM.nextInt(SIZE));
  }
}