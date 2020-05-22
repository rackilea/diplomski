// Keep track of my state.
private static class AsDoublesState {

    // null means no number waiting for add.
    Double d = null;
    // null means not seen '.' yet.
    Double div = null;
    // Is it negative.
    boolean neg = false;

    void consume(List<Double> doubles, char ch) {
        // Digit?
        if ('0' <= ch && ch <= '9') {
            double v = ch - '0';
            if (d == null) {
                d = v;
            } else {
                d = d * 10 + v;
            }
            // Count digits after the dot.
            if (div != null) {
                div *= 10;
            }
        } else if (ch == '.') {
            // Decimal point - start tracking how much to divide by.
            div = 1.0;
        } else if (ch == '-') {
            // Negate!
            neg = true;
        } else {
            // Everything else completes the number.
            if (d != null) {
                if (neg) {
                    d = -d;
                }
                if (div != null) {
                    doubles.add(d / div);
                } else {
                    doubles.add(d);
                }
                // Clear down.
                d = null;
                div = null;
                neg = false;
            }
        }
    }
}

private static List<Double> asDoubles(String s) {
    // Grow the list.
    List<Double> doubles = new ArrayList<>();
    // Track my state.
    AsDoublesState state = new AsDoublesState();

    for (int i = 0; i < s.length(); i++) {
        state.consume(doubles, s.charAt(i));
    }
    // Pretend a space on the end to flush an remaining number.
    state.consume(doubles, ' ');
    return doubles;
}

public void test() {
    String s = "16916576.643 4 -12312674.246 4        39.785 4  16916584.123 3  -5937726.325 3    36.794 3";
    List<Double> doubles = asDoubles(s);
    System.out.println(doubles);
}