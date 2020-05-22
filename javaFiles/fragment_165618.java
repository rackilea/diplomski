private static Number convert(Number num, Class<? extends Number> targetType) {
    Number result = null;
    if (Byte.class.equals(targetType)) {
        result = Byte.valueOf(num.byteValue());
    } else if (Short.class.equals(targetType)) {
        result = Short.valueOf(num.shortValue());
    } else if (...) {
         ...
    } else {
        throw new IllegalArgumentException("targetType is not a Number");
    }
    return result;
}