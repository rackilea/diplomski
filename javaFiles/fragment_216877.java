Map<Long, Post> postByIdMap = entityManager
.createQuery(
    "select p " +
    "from Post p ", Post.class)
.getResultStream()
.collect(
    Collectors.toMap(
        Post::getId,
        Function.identity()
    )
);

assertEquals(
    "High-Performance Java Persistence eBook has been released!",
    postByIdMap.get(1L).getTitle()
);

assertEquals(
    "Hypersistence Optimizer has been released!",
    postByIdMap.get(5L).getTitle()
);