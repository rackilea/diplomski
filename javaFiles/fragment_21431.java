public enum Move {
  UP("w", "^", new CoordinateChange(1, 0)),
  DOWN(...),
  LEFT(...),
  RIGHT(...);

  private final String key;
  private final String direction;
  private final coordinateChange;

  private CoordinateChange {
    private int x;
    private int y;
    // getter, setter, constructor
  }

  public static Move of(String keyboard) {
    // COnvert key board `w`,`s`, `a`, `d` to specific Move
  }
}