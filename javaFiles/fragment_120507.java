public static <T extends BusinessInterface> Collection<T> findOr(
    Context pContext, Class<T> pClass, Predicate<? super T>... pPredicates) {
  Predicate<? super T> lReducedPredicate = Arrays.asList(pPredicates).stream()
    .reduce((a,b) -> t -> a.test(t) || b.test(t)).orElse(r -> false);
  return find(pContext, pClass, lReducedPredicate);
}