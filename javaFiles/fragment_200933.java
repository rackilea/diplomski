Map<Integer,String> listMap =
   IntStream.range(0,lists.size())
            .boxed()
            .collect(Collectors.toMap(Function.identity(),
                                      lists::get,
                                      (a,b)->a,
                                      LinkedHashMap::new));