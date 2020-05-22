public static <T> UnaryOperator<StreamEx<T>> skipLast(int n)
{
   return(stream -> skipLast(stream, n));
}

private static StreamEx<T> skipLast(Stream<T> input, int n)
{
   // implement the real logic of skipLast
}