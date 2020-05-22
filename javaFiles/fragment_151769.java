/**
 * Calculates the expected QPS given a stableRate, a warmupPeriod, and a saturatedPeriod.
 * <p>
 * Both specified periods must use the same time unit.
 *
 * @param stableRate      how many permits become available per second once stable
 * @param warmupPeriod    the duration of the period where the {@code RateLimiter} ramps up
 *                        its rate, before reaching its stable (maximum) rate
 * @param saturatedPeriod the duration of the period for which the {@code RateLimiter} has
 *                        been under saturated demand starting from a cold state
 * @return The expected QPS assuming saturated demand starting from a cold state
 */
public static double qps(double stableRate, double warmupPeriod, double saturatedPeriod) {
    if (saturatedPeriod >= warmupPeriod) {
        return stableRate;
    }
    double coldRate = stableRate / 3.0;
    return (stableRate - coldRate) * saturatedPeriod / warmupPeriod + coldRate;
}