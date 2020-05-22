public static void main(String[] args) {
    int[] iT = new int[] { 1, 3, 5 };
    long[] lT = new long[] { 123, 456, 789 };
    double[] dT = new double[] { 1.2d, 3.2d, 5.2d };

    Integer[] boxedInts = IntStream.of(iT).boxed().toArray(Integer[]::new);
    Long[] boxedLongs = LongStream.of(lT).boxed().toArray(Long[]::new);
    Double[] boxedDoubles = DoubleStream.of(dT).boxed().toArray(Double[]::new);

    Collection<Object> collection = new ArrayList<>();

    collection.addAll(Arrays.asList(boxedInts));
    collection.addAll(Arrays.asList(boxedLongs));
    collection.addAll(Arrays.asList(boxedDoubles));

    for (Object element : collection) {
        System.out.print(element.toString() + " ");
    }
    //prints 1 3 5 123 456 789 1.2 3.2 5.2 
}