Single<Set<String>> sss = Single.just(Sets.newHashSet("1" , "2", "3"));

Single<Set<Integer>> ssi = sss
    .flattenAsFlowable(e -> e)
    .parallel()
    .runOn(Schedulers.computation())
    .map(Integer::parseInt)
    .sequential()
    .toList(HashSet::new);