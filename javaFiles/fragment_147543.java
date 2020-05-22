public static <T, R> ThrowingFunctionChain<T, R> function(
    final ThrowingFunction<T, R> function)
{
    return new ThrowingFunctionChain<>(function);
}
public static <T, R> Function<T, R> function(
    final ThrowingFunction<T, R> function, Function<T, R> fallBack)
{
    return new ThrowingFunctionChain<>(function).fallbackTo(fallBack);
}
public static void main(final String... args)
{
    Function<Path, Path> f = function(Path::toRealPath, Path::toAbsolutePath);
}