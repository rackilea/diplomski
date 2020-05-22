/**
 * Used to estimate the radius of a circle to be constrained within the widget
 * according to the input parameters. Doubling the returned value would give
 * you the size of a contained Actor which would roughly fill most of its
 * sector, or possibly overflow slightly. It is suggested to adjust slightly
 * the returned value by multiplying it with a factor of your choice.<br>
 * It's basically the minimum between 3 different possible radius values
 * based on certain layout properties.
 *
 * @param degreesPerChild the amount of degrees that a child's sector takes.
 * @param actorDistanceFromCenter the distance at which the child Actor is
 *                                positioned from the center of the widget.
 * @return an estimated radius value for an Actor placed with the given
 *         constraints.
 */
public float getEstimatedRadiusAt(float degreesPerChild, float actorDistanceFromCenter) {
    float tmp1 = actorDistanceFromCenter * MathUtils.sinDeg(degreesPerChild/2);
    float tmp2 = getMaxRadius() - actorDistanceFromCenter;
    float tmp3 = actorDistanceFromCenter - getInnerRadiusLength();
    return Math.min(Math.min(tmp1, tmp2), tmp3);
}