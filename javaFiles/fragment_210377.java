// Default delta to apply.
public static final double DELTA = 0.000001;

public static Rational valueOf(double dbl) {
  return valueOf(dbl, DELTA);
}

// Create a good rational for the value within the delta supplied.
public static Rational valueOf(double dbl, double delta) {
    // Primary checks.
    if ( delta <= 0.0 ) {
        throw new IllegalArgumentException("Delta must be > 0.0");
    }
    // Remove the integral part.
    long integral = (long) Math.floor(dbl);
    dbl -= integral;
    // The value we are looking for.
    final Rational d = new Rational((long) ((dbl) / delta), (long) (1 / delta));
    // Min value = d - delta.
    final Rational min = new Rational((long) ((dbl - delta) / delta), (long) (1 / delta));
    // Max value = d + delta.
    final Rational max = new Rational((long) ((dbl + delta) / delta), (long) (1 / delta));
    // Start the fairey sequence.
    Rational l = ZERO;
    Rational h = ONE;
    Rational found = null;
    // Keep slicing until we arrive within the delta range.
    do {
        // Either between min and max -> found it.
        if (found == null && min.compareTo(l) <= 0 && max.compareTo(l) >= 0) {
            found = l;
        }
        if (found == null && min.compareTo(h) <= 0 && max.compareTo(h) >= 0) {
            found = h;
        }
        if (found == null) {
            // Make the mediant.
            Rational m = mediant(l, h);
            // Replace either l or h with mediant.
            if (m.compareTo(d) < 0) {
                l = m;
            } else {
                h = m;
            }
        }

    } while (found == null);

    // Bring back the sign and the integral.
    if (integral != 0) {
        found = found.plus(new Rational(integral, 1));
    }
    // That's me.
    return found;
}    

public BigDecimal toBigDecimal() {
  // Do it to just 4 decimal places.
  return toBigDecimal(4);
}

public BigDecimal toBigDecimal(int digits) {
  // Do it to n decimal places.
  return new BigDecimal(num).divide(new BigDecimal(den), digits, RoundingMode.DOWN).stripTrailingZeros();
}