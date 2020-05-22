entityManager.persist(
    new Post()
        .setId(1L)
        .setTitle("High-Performance Java Persistence eBook has been released!")
        .setCreatedOn(LocalDate.of(2016, 8, 30))
);

entityManager.persist(
    new Post()
        .setId(2L)
        .setTitle("High-Performance Java Persistence paperback has been released!")
        .setCreatedOn(LocalDate.of(2016, 10, 12))
);

entityManager.persist(
    new Post()
        .setId(3L)
        .setTitle("High-Performance Java Persistence Mach 1 video course has been released!")
        .setCreatedOn(LocalDate.of(2018, 1, 30))
);

entityManager.persist(
    new Post()
        .setId(4L)
        .setTitle("High-Performance Java Persistence Mach 2 video course has been released!")
        .setCreatedOn(LocalDate.of(2018, 5, 8))
);

entityManager.persist(
    new Post()
        .setId(5L)
        .setTitle("Hypersistence Optimizer has been released!")
        .setCreatedOn(LocalDate.of(2019, 3, 19))
);