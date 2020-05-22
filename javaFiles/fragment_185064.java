interface Series {
   double x(int m);
}

class ExampleSeries implements Series {
    public double x(int m) {
        if (m == 0) {
            return 0;
        }

        return 1 / (1 + x(m - 1));
    }
}

class SeriesUtil {
    public static double sum(Series series, int lowerBound, int upperBound) {
        int sum = 0;
        for (int i = lowerBound; i <= upperBound) {
            sum += x(i);
        }

        return sum;
    }
}