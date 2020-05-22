public static boolean contains(Collection<Double> collection, double key) {
    for (double d : collection) {
        if (Math.abs(d/key - 1) < threshold)
            return true;
    }
    return false;
}