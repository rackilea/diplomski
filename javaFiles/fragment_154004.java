@EntityGraph(attributePaths = {"bar"})
  @Override
  List<Foo> findAll();

  @EntityGraph(attributePaths = {"bar"})
  @Override
  Page<Foo> findAll(Pageable pageable);