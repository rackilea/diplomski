public static <T> T pickRandomly(List<T> list, float p) {
    if (p <= 0 || p >= 1.0)
        throw new IllegalArgumentException();
    double a = Math.log(1.0 - p) / Math.log(p);
    double x = rnd.nextDouble();
    double y = (Math.pow(x, a) + 1.0 - Math.pow(1.0 - x, 1.0 / a)) / 2.0;
    return list.get((int) (list.size() * y));
}