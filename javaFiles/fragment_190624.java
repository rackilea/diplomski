public static double bisect(double a, double b, double tolerance) {
    double m = (a + b) / 2;
    double q = 0;
    while (q < tolerance) {
        if (m*m*m - 2*m - 3 == 0)
            return m;
        else if ((a*a*a - 2*a - 3) * (m*m*m - 2*m - 3) < 0)
            m = bisect(a, m, 1.0e-10);
        else if ((b*b*b - 2*b - 3) * (m*m*m - 2*m - 3) < 0)
            m = bisect(m, b, 1e-10);
        q++;
    }
    return m;
}