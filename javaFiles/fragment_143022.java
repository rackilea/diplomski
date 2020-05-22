/**
 * Compute the natural logarithm of x to a given scale, x > 0.
 */
public static BigDecimal ln(BigDecimal x, int scale)
{
    // Check that x > 0.
    if (x.signum() <= 0) {
        throw new IllegalArgumentException("x <= 0");
    }

    // The number of digits to the left of the decimal point.
    int magnitude = x.toString().length() - x.scale() - 1;

    if (magnitude < 3) {
        return lnNewton(x, scale);
    }

    // Compute magnitude*ln(x^(1/magnitude)).
    else {

        // x^(1/magnitude)
        BigDecimal root = intRoot(x, magnitude, scale);

        // ln(x^(1/magnitude))
        BigDecimal lnRoot = lnNewton(root, scale);

        // magnitude*ln(x^(1/magnitude))
        return BigDecimal.valueOf(magnitude).multiply(lnRoot)
                    .setScale(scale, BigDecimal.ROUND_HALF_EVEN);
    }
}

/**
 * Compute the natural logarithm of x to a given scale, x > 0.
 * Use Newton's algorithm.
 */
private static BigDecimal lnNewton(BigDecimal x, int scale)
{
    int        sp1 = scale + 1;
    BigDecimal n   = x;
    BigDecimal term;

    // Convergence tolerance = 5*(10^-(scale+1))
    BigDecimal tolerance = BigDecimal.valueOf(5)
                                        .movePointLeft(sp1);

    // Loop until the approximations converge
    // (two successive approximations are within the tolerance).
    do {

        // e^x
        BigDecimal eToX = exp(x, sp1);

        // (e^x - n)/e^x
        term = eToX.subtract(n)
                    .divide(eToX, sp1, BigDecimal.ROUND_DOWN);

        // x - (e^x - n)/e^x
        x = x.subtract(term);

        Thread.yield();
    } while (term.compareTo(tolerance) > 0);

    return x.setScale(scale, BigDecimal.ROUND_HALF_EVEN);
}

/**
 * Compute the integral root of x to a given scale, x >= 0.
 * Use Newton's algorithm.
 * @param x the value of x
 * @param index the integral root value
 * @param scale the desired scale of the result
 * @return the result value
 */
public static BigDecimal intRoot(BigDecimal x, long index,
                                 int scale)
{
    // Check that x >= 0.
    if (x.signum() < 0) {
        throw new IllegalArgumentException("x < 0");
    }

    int        sp1 = scale + 1;
    BigDecimal n   = x;
    BigDecimal i   = BigDecimal.valueOf(index);
    BigDecimal im1 = BigDecimal.valueOf(index-1);
    BigDecimal tolerance = BigDecimal.valueOf(5)
                                        .movePointLeft(sp1);
    BigDecimal xPrev;

    // The initial approximation is x/index.
    x = x.divide(i, scale, BigDecimal.ROUND_HALF_EVEN);

    // Loop until the approximations converge
    // (two successive approximations are equal after rounding).
    do {
        // x^(index-1)
        BigDecimal xToIm1 = intPower(x, index-1, sp1);

        // x^index
        BigDecimal xToI =
                x.multiply(xToIm1)
                    .setScale(sp1, BigDecimal.ROUND_HALF_EVEN);

        // n + (index-1)*(x^index)
        BigDecimal numerator =
                n.add(im1.multiply(xToI))
                    .setScale(sp1, BigDecimal.ROUND_HALF_EVEN);

        // (index*(x^(index-1))
        BigDecimal denominator =
                i.multiply(xToIm1)
                    .setScale(sp1, BigDecimal.ROUND_HALF_EVEN);

        // x = (n + (index-1)*(x^index)) / (index*(x^(index-1)))
        xPrev = x;
        x = numerator
                .divide(denominator, sp1, BigDecimal.ROUND_DOWN);

        Thread.yield();
    } while (x.subtract(xPrev).abs().compareTo(tolerance) > 0);

    return x;
}

/**
 * Compute e^x to a given scale.
 * Break x into its whole and fraction parts and
 * compute (e^(1 + fraction/whole))^whole using Taylor's formula.
 * @param x the value of x
 * @param scale the desired scale of the result
 * @return the result value
 */
public static BigDecimal exp(BigDecimal x, int scale)
{
    // e^0 = 1
    if (x.signum() == 0) {
        return BigDecimal.valueOf(1);
    }

    // If x is negative, return 1/(e^-x).
    else if (x.signum() == -1) {
        return BigDecimal.valueOf(1)
                    .divide(exp(x.negate(), scale), scale,
                            BigDecimal.ROUND_HALF_EVEN);
    }

    // Compute the whole part of x.
    BigDecimal xWhole = x.setScale(0, BigDecimal.ROUND_DOWN);

    // If there isn't a whole part, compute and return e^x.
    if (xWhole.signum() == 0) return expTaylor(x, scale);

    // Compute the fraction part of x.
    BigDecimal xFraction = x.subtract(xWhole);

    // z = 1 + fraction/whole
    BigDecimal z = BigDecimal.valueOf(1)
                        .add(xFraction.divide(
                                xWhole, scale,
                                BigDecimal.ROUND_HALF_EVEN));

    // t = e^z
    BigDecimal t = expTaylor(z, scale);

    BigDecimal maxLong = BigDecimal.valueOf(Long.MAX_VALUE);
    BigDecimal result  = BigDecimal.valueOf(1);

    // Compute and return t^whole using intPower().
    // If whole > Long.MAX_VALUE, then first compute products
    // of e^Long.MAX_VALUE.
    while (xWhole.compareTo(maxLong) >= 0) {
        result = result.multiply(
                            intPower(t, Long.MAX_VALUE, scale))
                    .setScale(scale, BigDecimal.ROUND_HALF_EVEN);
        xWhole = xWhole.subtract(maxLong);

        Thread.yield();
    }
    return result.multiply(intPower(t, xWhole.longValue(), scale))
                    .setScale(scale, BigDecimal.ROUND_HALF_EVEN);
}