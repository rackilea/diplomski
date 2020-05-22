public static <T> boolean eq(Value<T> obj, T value)
{
    return Objects.equals(obj.value, value);
}

public static <T extends Comparable<T>> boolean gt(Value<T> obj, T value)
{
    return obj.value.compareTo(value) > 0;
}

public static <T extends String> boolean match(Value<T> obj, T value)
{
    return obj.value.equalsIgnoreCase(value);
}