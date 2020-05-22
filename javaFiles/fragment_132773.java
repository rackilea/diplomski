public static void main(String... args) {
    Object[] doubles = new Object[100000];
    Arrays.fill(doubles, 0.0);
    doubles[100] = null;
    doubles[1000] = null;
    for (int i = 0; i < 6; i++) {
        testSameClass(doubles);
        testSuperClass(doubles);
        testInterface(doubles);
    }
}

private static int testSameClass(Object[] doubles) {
    long start = System.nanoTime();
    int count = 0;
    for (Object d : doubles) {
        if (d instanceof Double)
            count++;
    }
    long time = System.nanoTime() - start;
    System.out.printf("instanceof Double took an average of %.1f ns%n", 1.0 * time / doubles.length);
    return count;
}

private static int testSuperClass(Object[] doubles) {
    long start = System.nanoTime();
    int count = 0;
    for (Object d : doubles) {
        if (d instanceof Number)
            count++;
    }
    long time = System.nanoTime() - start;
    System.out.printf("instanceof Number took an average of %.1f ns%n", 1.0 * time / doubles.length);
    return count;
}

private static int testInterface(Object[] doubles) {
    long start = System.nanoTime();
    int count = 0;
    for (Object d : doubles) {
        if (d instanceof Serializable)
            count++;
    }
    long time = System.nanoTime() - start;
    System.out.printf("instanceof Serializable took an average of %.1f ns%n", 1.0 * time / doubles.length);
    return count;
}