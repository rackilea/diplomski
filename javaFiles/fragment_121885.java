private static final Map<Class<? extends Number>, Integer> RANKS;

static {
    Map<Class<? extends Number>, Integer> map = new IdentityHashMap<>();
    map.put(Byte.class, 0);
    map.put(Short.class, 1);
    map.put(Integer.class, 2);
    map.put(Long.class, 3);
    map.put(BigInteger.class, 4);
    map.put(Float.class, 5);
    map.put(Double.class, 6);
    map.put(BigDecimal.class, 7);
    RANKS = Collections.unmodifiableMap(map);
}

private static Number addBytes(Number... numbers) {
    byte a = 0;
    for (Number number : numbers)
        a += number.byteValue();
    return a;
}

private static Number addShorts(Number... numbers) {
    short a = 0;
    for (Number number : numbers)
        a += number.shortValue();
    return a;
}

private static Number addInts(Number... numbers) {
    int a = 0;
    for (Number number : numbers)
        a += number.intValue();
    return a;
}

private static Number addLongs(Number... numbers) {
    long a = 0;
    for (Number number : numbers)
        a += number.longValue();
    return a;
}

private static Number addBigIntegers(Number... numbers) {
    BigInteger a = BigInteger.ZERO;
    for (Number number : numbers)
        a = a.add(number instanceof BigInteger ? (BigInteger) number : BigInteger.valueOf(number.longValue()));
    return a;
}

private static Number addFloats(Number... numbers) {
    float a = 0;
    for (Number number : numbers)
        a += number.floatValue();
    return a;
}

private static Number addDoubles(Number... numbers) {
    double a = 0;
    for (Number number : numbers)
        a += number.doubleValue();
    return a;
}

private static Number addBigDecimals(Number... numbers) {
    BigDecimal a = BigDecimal.ZERO;
    for (Number number : numbers) {
        a = a.add(
                number instanceof BigDecimal ? (BigDecimal) number
                        : number instanceof BigInteger ? new BigDecimal((BigInteger) number)
                        : new BigDecimal(number.doubleValue()));
    }
    return a;
}

public static Number add(Number... numbers) {
    if (numbers.length == 0)
        return 0;
    int max = -1;
    for (Number number : numbers) {
        Integer rank = RANKS.get(number.getClass());
        if (rank == null)
            throw new IllegalArgumentException();
        max = Math.max(max, rank);
    }
    switch (max) {
        case 0: return addBytes(numbers);
        case 1: return addShorts(numbers);
        case 2: return addInts(numbers);
        case 3: return addLongs(numbers);
        case 4: return addBigIntegers(numbers);
        case 5: return addFloats(numbers);
        case 6: return addDoubles(numbers);
        case 7: return addBigDecimals(numbers);
        default: throw new IllegalStateException();
    }
}