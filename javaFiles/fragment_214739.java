private static final SecureRandom RND = new SecureRandom();
    private static final int COUNT_MAX = 100;

    public static void main(String[] args) {
        ArrayList<Integer> ints = getCollection(ArrayList::new, Number::intValue);
        System.out.println(ints);
        Set<Double> doubles = getCollection(HashSet::new, Number::doubleValue);
        System.out.println(doubles);
    }

    private static <T extends Collection<U>, U extends Number> T getCollection(
        Supplier<T> supplier, Function<Number, U> fn) {
        T collection = supplier.get();
        int count = RND.nextInt(COUNT_MAX);
        for (int i = 0; i < count; i++)
            collection.add(fn.apply(RND.nextInt()));
        return collection;
    }