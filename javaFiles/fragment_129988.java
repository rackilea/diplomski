class HashMap {
    private final HashingStrategy strategy;

    private int computeHash(object) {
       return strategy.hash(object);
    }
}