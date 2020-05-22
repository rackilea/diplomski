/**
   * Takes a {@link Point} and calculates the circle polygon given a radius in degrees, radians,
   * miles, or kilometers; and steps for precision. This uses the {@link #DEFAULT_STEPS} and
   * {@link TurfConstants#UNIT_DEFAULT} values.
   *
   * @param center a {@link Point} which the circle will center around
   * @param radius the radius of the circle
   * @return a {@link Polygon} which represents the newly created circle
   * @since 3.0.0
   */
  public static Polygon circle(@NonNull Point center, double radius) {
    return circle(center, radius, 64, TurfConstants.UNIT_DEFAULT);
  }