/**
 * Generates a new point within a circular radius from
 * the given <tt>x</tt> and <tt>y</tt> coordinates. This
 * is done by generating a random offset along the
 * horizontal axis, then applying a rotation.
 *
 * @param seed The seed to generate the point from.
 * @param x    The x coordinate of the center of the
 *             circle.
 * @param y    The y coordinate of the center of the
 *             circle.
 * @return The newly generated point, within the
 * specified radius of the point <tt>(x, y)
 * </tt>.
 * @see ClusterGenerator#RADIUS
 */

private static Point makePoint(final Random seed, final int x, final int y) {
    final int offset = seed.nextInt(RADIUS);
    final double rotation = 2 * Math.PI * Math.random();
    final int x1 = (int) (Math.sin(rotation) * offset);
    final int y1 = (int) (Math.cos(rotation) * offset);
    return new Point(x + x1, y + y1);
}