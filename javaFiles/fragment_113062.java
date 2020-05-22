List<Category> categories = new ArrayList<>();
  datastore.createAggregation(Fruits.class)
        .match(query)
        .unwind("categories")
        .group(Group.id(Group.grouping("categories")))
        .sort(Sort.ascending("_id.categories"))
        .project(Projection.projection("_id").suppress(), Projection.projection("category", "_id.categories"))
        .aggregate(Category.class).forEachRemaining(categories::add);


class Category {
    private String category;
}