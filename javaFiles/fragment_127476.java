public static void main(final String[] args) {
    final double[] original = new double[] { 2.0, 6.0, 8.0 };
    final double[] normalized = getNormalized(original);

    final int[] positionPicked = new int[original.length];
    final Random rnd = new Random();
    for (int i = 0; i < 10000; i++) {
        final double d = rnd.nextDouble();
        final int position = getPosition(normalized, d);
        positionPicked[position]++;
    }

    for (final int p : positionPicked)
        System.out.println(p);
}

static double[] getNormalized(final double[] original) {
    double s = 0.0;
    for (final double e : original)
        s += e;
    final double[] normalized = new double[original.length];
    for (int i = 0; i < original.length; i++)
        normalized[i] = original[i] / s;
    return normalized;
}

static int getPosition(final double[] normalized, final double v) {
    double s = 0;
    for (int i = 0; i < normalized.length; i++) {
        s += normalized[i];
        if (s >= v)
            return i;
    }
    return normalized.length - 1;
}