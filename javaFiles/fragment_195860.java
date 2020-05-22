public static <T,K> Map<K,Integer> mapper (
    Collection<T> ts,
    Function<T, K> classifier,
    Function<T, Integer> evaluator,
    Function<Integer,Integer> calculator) 
{
     return
        ts.stream()
          .collect(Collectors.groupingBy(classifier,
                                         Collectors.summingInt(t->evaluator.andThen(calculator).apply(t))));
}