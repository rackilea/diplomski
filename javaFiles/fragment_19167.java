results.stream().collect(
    Collectors.toMap(
         Numbers::getUserId,
         x -> x.getNumber1() + x.getNumber2(),
         Long::sum   
    )
);