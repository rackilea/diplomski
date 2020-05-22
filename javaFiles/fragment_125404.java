// Keep track of my state.
private static class AsDoublesState {

    // Mutable double value.
    AtomicDouble d = new AtomicDouble();
    // Mutable double value.
    AtomicDouble div = new AtomicDouble();
    // Is there a number.
    boolean number = false;
    // Is it negative.
    boolean negative = false;

    void consume(List<Double> doubles, char ch) {
        // Digit?
        if ('0' <= ch && ch <= '9') {
            double v = ch - '0';
            d.set(d.get() * 10 + v);
            number = true;
            // Count digits after the dot.
            div.set(div.get() * 10);
        } else if (ch == '.') {
            // Decimal point - start tracking how much to divide by.
            div.set(1.0);
        } else if (ch == '-') {
            // Negate!
            negative = true;
        } else {
            // Everything else completes the number.
            if (number) {
                double v = d.get();
                if (negative) {
                    v = -v;
                }
                if (div.get() != 0) {
                    v = v / div.get();
                }
                doubles.add(v);
                // Clear down.
                d.set(0);
                div.set(0);
                number = false;
                negative = false;
            }
        }
    }
}