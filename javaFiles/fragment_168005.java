BiFunction<EntityChain, Entity, EntityChain> reducing =
    (next, entity) -> Optional.ofNullable(next)
                    // create a builder with fallback if EntityChain present
                    .map(fallback -> EntityChain.builder().withFallback(fallback))
                    // create a builder without fallback
                    .orElseGet(EntityChain::builder)
                    //build the EntityChain
                    .withEntity(entity).build();

// combiner never be used in sequentially stream
BinaryOperator<EntityChain> rejectedInParallelStream = (t1, t2) -> {
    //when you use parallel the chain order maybe changed, and the result is wrong.
    throw new IllegalStateException("Can't be used in parallel stream!");
};


EntityChain chain = reverse(entities).
        stream().reduce(null, reducing, rejectedInParallelStream);


//copy & reverse the copied List
static <T> List<T> reverse(List<T> list) {
    List<T> it = list.stream().collect(Collectors.toList());
    Collections.reverse(it);
    return it;
}