public Flux<Item> export(String productType) {
    int pageSize = 1000;
    int count = jdbc.count();
    return Flux.range(0, count / pageSize) //page numbers
        .flatMapIterable(pageNumber ->
            jdbc.queryForList("SELECT ref_id FROM products where type = ? LIMIT ? OFFSET = ?",
                String.class,
                productType,
                pageSize,
                pageNumber * pageSize))
        .map(id -> {
          Map map = jdbc.queryForMap("SELECT <anything> ... where some_id = ?", id);
          Item item = new Item();
          //
          //
          return item;
        });
  }