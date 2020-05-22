public static double hueToRgb(double p, double q, double t) {
    if (t < 0) {
        t += 1;
    }
    if (t > 1) {
        t -= 1;
    }

    if (t < 1.0 / 6) {
        return p + (q - p) * 6 * t;
    }
    if (t < 1.0 / 2) {
        return q;
    }
    if (t < 2.0 / 3) {
        return p + (q - p) * (2.0 / 3 - t) * 6;
    }
    return p;
}