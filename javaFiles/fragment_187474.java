public static class ThreeInts {
    private final int first;
    private final int second;
    private final int third;
    ...
}

AtomicReference<ThreeInts> threeInts = new AtomicReference<>(someDefault);