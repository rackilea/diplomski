static public double next(Random rnd, double median, double a, double b, double min, double max) {
    double d = -3;
    while (d > 2.698 || d < -2.698) {
        d = rnd.nextGaussian();
    }
    if (Math.abs(d) < 0.6745) {
        if (d < 0) {
            return median - (median - a) / 0.6745 * (-d);  // 2nd quartile
        } else {
            return median + (b - median) / 0.6745 * d;  // 3rd quartile
        }
    } else {
        if (d < 0) {
            return a - (a - min) / (2.698 - 0.6745) * ((-d) - 0.6745);  // 1st quartile
        } else {
            return b + (max - b) / (2.698 - 0.6745) * (d - 0.6745);  // 4th quartile
        }
    }
}