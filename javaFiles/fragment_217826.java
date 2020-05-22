private static Object sum(List<? extends Number> list) {
    Integer integerSum = 0;
    Double doubleSum = 0.0;
    boolean hasDouble = false;
    for (Number i: list) {
        if (i instanceof Integer) {
            integerSum += i.intValue();
        } else {
            doubleSum += i.doubleValue();
            hasDouble = true;
        }
    }
    if (hasDouble)
        return doubleSum + integerSum;
    return integerSum;
}