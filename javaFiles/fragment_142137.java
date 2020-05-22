public static Double[][] box(double unboxed[][]) {
    return Arrays.stream(unboxed).map(Boxer::box).toArray(Double[][]::new);
}

public static double[][] unbox(Double boxed[][]) {
    return Arrays.stream(boxed).map(TmpTest::unbox).toArray(double[][]::new);
}